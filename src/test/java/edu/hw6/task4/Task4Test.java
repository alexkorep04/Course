package edu.hw6.task4;

import edu.hw6.PrintComposition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import static org.assertj.core.api.Assertions.assertThat;

public class Task4Test {
    PrintComposition printComposition;
    private static final String DIRECTORY = "./src/test/java/edu/hw6/task4/";
    @BeforeEach
    public void createObject() {
        printComposition = new PrintComposition();
    }
    @Test
    @DisplayName("Test writing to file")
    public void testWriting() throws IOException {
        String expected = "hi!";
        printComposition.writeText(DIRECTORY + "test.txt", expected);

        String response;

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(DIRECTORY + "test.txt"))) {
            response = bufferedReader.readLine();
        }

        assertThat(expected).isEqualTo(response);
    }
}
