package edu.hw6.task2;

import edu.hw6.FileCloning;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task2Test {
    FileCloning fileCloning;
    private static final String DIRECTORY = ".\\src\\test\\java\\edu\\hw6\\task2\\";
    @BeforeEach
    public void createObject() {
        fileCloning = new FileCloning();
    }
    @Test
    @DisplayName("Test creating first copy of test.txt")
    public void createFirstCopy() throws IOException {
        Path original = Path.of(DIRECTORY + "test.txt");
        Path firstCopy = Path.of(DIRECTORY + "test — копия.txt");
        Files.deleteIfExists(firstCopy);

        fileCloning.cloneFile(original);
        boolean response1 = Files.exists(firstCopy);
        boolean response2 = Files.exists(original);

        assertThat(response1).isTrue();
        assertThat(response2).isTrue();
    }
    @Test
    @DisplayName("Test creating second copy of test.txt")
    public void createSecondCopy() throws IOException {
        Path original = Path.of(DIRECTORY + "test.txt");
        Path firstCopy = Path.of(DIRECTORY + "test — копия.txt");
        Path secondCopy = Path.of(DIRECTORY + "test — копия (2).txt");
        Files.deleteIfExists(secondCopy);

        fileCloning.cloneFile(original);
        boolean response1 = Files.exists(secondCopy);
        boolean response2 = Files.exists(firstCopy);
        boolean response3 = Files.exists(original);

        assertThat(response1).isTrue();
        assertThat(response2).isTrue();
        assertThat(response3).isTrue();

    }
    @Test
    @DisplayName("Test creating third copy of test.txt")
    public void createThirdCopy() throws IOException {
        Path original = Path.of(DIRECTORY + "test.txt");
        Path firstCopy = Path.of(DIRECTORY + "test — копия.txt");
        Path secondCopy = Path.of(DIRECTORY + "test — копия (2).txt");
        Path thirdCopy = Path.of(DIRECTORY + "test — копия (3).txt");
        Files.deleteIfExists(thirdCopy);

        fileCloning.cloneFile(original);
        boolean response1 = Files.exists(thirdCopy);
        boolean response2 = Files.exists(secondCopy);
        boolean response3 = Files.exists(firstCopy);
        boolean response4 = Files.exists(original);

        assertThat(response1).isTrue();
        assertThat(response2).isTrue();
        assertThat(response3).isTrue();
        assertThat(response4).isTrue();
    }
}
