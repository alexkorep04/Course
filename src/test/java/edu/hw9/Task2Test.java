package edu.hw9;

import edu.hw9.Task2.DirectoryFinder;
import edu.hw9.Task2.FileFinder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import static org.apache.logging.log4j.core.util.FileUtils.getFileExtension;
import static org.assertj.core.api.Assertions.*;

public class Task2Test {
    DirectoryFinder directoryFinder;
    FileFinder fileFinder;
    ForkJoinPool forkJoinPool;

    @Test
    @DisplayName("Test directory finder")
    public void testDirectoryFinder() {
        directoryFinder = new DirectoryFinder(Path.of("./src/main/java/edu/hw9/Task2/files/"), 3);
        forkJoinPool = new ForkJoinPool();
        List<String> expected = List.of("./src/main/java/edu/hw9/Task2/files/dir", "./src/main/java/edu/hw9/Task2/files/dir/dir2");

        List<String> response = forkJoinPool.invoke(directoryFinder);
        response = response.stream().sorted().toList();

        assertThat(expected.size()).isEqualTo(response.size());
        assertThat(expected).isEqualTo(response);
    }

    @Test
    @DisplayName("Test directory finder, when there are no acceptable directories")
    public void testDirectoryFinderNoAcceptable() {
        directoryFinder = new DirectoryFinder(Path.of("./src/main/java/edu/hw9/Task2/files/"), 5);
        forkJoinPool = new ForkJoinPool();
        List<String> expected = List.of();

        List<String> response = forkJoinPool.invoke(directoryFinder);

        assertThat(expected.size()).isEqualTo(response.size());
        assertThat(expected).isEqualTo(response);
    }

    @Test
    @DisplayName("Test size of file")
    public void testSize() {
        fileFinder = new FileFinder(Path.of("./src/main/java/edu/hw9/Task2/files/"), p -> {
            try {
                return Files.size(p) > 2;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        forkJoinPool = new ForkJoinPool();

        List<String> expected = List.of("./src/main/java/edu/hw9/Task2/files/2.txt"
            , "./src/main/java/edu/hw9/Task2/files/dir/3.txt"
            , "./src/main/java/edu/hw9/Task2/files/dir/5.txt"
            , "./src/main/java/edu/hw9/Task2/files/dir/dir2/7.txt");

        List<String> response = forkJoinPool.invoke(fileFinder);
        response = response.stream().sorted().toList();

        assertThat(expected.size()).isEqualTo(response.size());
        assertThat(expected).isEqualTo(response);
    }

    @Test
    @DisplayName("Test extension of files")
    public void testExtensione() {
        fileFinder = new FileFinder(Path.of("./src/main/java/edu/hw9/Task2/files/"), p ->
            "rtf".equals(getFileExtension(p.toFile())));
        forkJoinPool = new ForkJoinPool();

        List<String> expected = List.of("./src/main/java/edu/hw9/Task2/files/1.rtf"
            , "./src/main/java/edu/hw9/Task2/files/dir/dir2/8.rtf");

        List<String> response = forkJoinPool.invoke(fileFinder);
        response = response.stream().sorted().toList();

        assertThat(expected.size()).isEqualTo(response.size());
        assertThat(expected).isEqualTo(response);
    }
}
