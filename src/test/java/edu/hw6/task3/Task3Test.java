package edu.hw6.task3;

import edu.hw6.FilesFilters;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static edu.hw6.FilesFilters.READABLE_FILE;
import static edu.hw6.FilesFilters.REGULAR_FILE;
import static edu.hw6.FilesFilters.WRITABLE_FILE;
import static edu.hw6.FilesFilters.globMatches;
import static edu.hw6.FilesFilters.largerThan;
import static edu.hw6.FilesFilters.magicNumber;
import static edu.hw6.FilesFilters.regexContains;
import static org.assertj.core.api.Assertions.assertThat;

public class Task3Test {
    private static final String DIRECTORY = "./src/test/java/edu/hw6/task3/";

    @Test
    @DisplayName("Test size")
    public void testSize() throws IOException {
        DirectoryStream.Filter<Path> filter = REGULAR_FILE
            .and(largerThan(10));
        List<String> response = new ArrayList<>();
        try (DirectoryStream<Path> entries = Files.newDirectoryStream(Path.of(DIRECTORY), filter)) {
            entries.forEach(path ->
                response.add(path.getFileName().toString())
            );
        }

        List<String> expected = List.of("Task3Test.java", "test1.txt");
        Collections.sort(response);

        assertThat(expected.size()).isEqualTo(response.size());
        assertThat(expected).isEqualTo(response);
    }

    @Test
    @DisplayName("Test writable")
    public void testWritable() throws IOException {
        DirectoryStream.Filter<Path> filter = REGULAR_FILE
            .and(WRITABLE_FILE);
        List<String> response = new ArrayList<>();
        try (DirectoryStream<Path> entries = Files.newDirectoryStream(Path.of(DIRECTORY), filter)) {
            entries.forEach(path ->
                response.add(path.getFileName().toString())
            );
        }

        List<String> expected = List.of("Task3Test.java", "test1.txt", "test2.txt", "test3.txt");
        Collections.sort(response);

        assertThat(expected.size()).isEqualTo(response.size());
        assertThat(expected).isEqualTo(response);
    }

    @Test
    @DisplayName("Test glob matches")
    public void tesGlobMatches() throws IOException {
        DirectoryStream.Filter<Path> filter = REGULAR_FILE
            .and(globMatches("*.txt"));
        List<String> response = new ArrayList<>();
        try (DirectoryStream<Path> entries = Files.newDirectoryStream(Path.of(DIRECTORY), filter)) {
            entries.forEach(path ->
                response.add(path.getFileName().toString())
            );
        }

        List<String> expected = List.of("test1.txt", "test2.txt", "test3.txt");
        Collections.sort(response);

        assertThat(expected.size()).isEqualTo(response.size());
        assertThat(expected).isEqualTo(response);
    }

    @Test
    @DisplayName("Test magicNumber matches")
    public void tesMagicNumber() throws IOException {
        char[] chars = new char[1];
        chars[0] = '1';
        DirectoryStream.Filter<Path> filter = REGULAR_FILE
            .and(magicNumber(chars));
        List<String> response = new ArrayList<>();
        try (DirectoryStream<Path> entries = Files.newDirectoryStream(Path.of(DIRECTORY), filter)) {
            entries.forEach(path ->
                response.add(path.getFileName().toString())
            );
        }

        List<String> expected = List.of("test1.txt");
        Collections.sort(response);

        assertThat(expected.size()).isEqualTo(response.size());
        assertThat(expected).isEqualTo(response);
    }

    @Test
    @DisplayName("Test regex contains matches")
    public void testRegex() throws IOException {
        DirectoryStream.Filter<Path> filter = REGULAR_FILE
            .and(regexContains("test\\d"));
        List<String> response = new ArrayList<>();
        try (DirectoryStream<Path> entries = Files.newDirectoryStream(Path.of(DIRECTORY), filter)) {
            entries.forEach(path ->
                response.add(path.getFileName().toString())
            );
        }

        List<String> expected = List.of("test1.txt", "test2.txt", "test3.txt");
        Collections.sort(response);

        assertThat(expected.size()).isEqualTo(response.size());
        assertThat(expected).isEqualTo(response);
    }

    @Test
    @DisplayName("Test all")
    public void testAll() throws IOException {
        char[] chars = new char[1];
        chars[0] = '1';
        DirectoryStream.Filter<Path> filter = REGULAR_FILE
            .and(regexContains("test\\d"))
            .and(globMatches("*.txt"))
            .and(magicNumber(chars))
            .and(largerThan(10))
            .and(READABLE_FILE)
            .and(WRITABLE_FILE);
        List<String> response = new ArrayList<>();
        try (DirectoryStream<Path> entries = Files.newDirectoryStream(Path.of(DIRECTORY), filter)) {
            entries.forEach(path ->
                response.add(path.getFileName().toString())
            );
        }

        List<String> expected = List.of("test1.txt");
        Collections.sort(response);

        assertThat(expected.size()).isEqualTo(response.size());
        assertThat(expected).isEqualTo(response);
    }
}
