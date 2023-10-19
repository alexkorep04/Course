package edu.hw3;

import edu.hw3.task1.AtbashCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
public class Task1Test {
    @ParameterizedTest
    @CsvSource(value = {"Hello world, Svool dliow", "abcde, zyxwv", "a, z"})
    @DisplayName("Test strings that contain only latin symbols")
    public void testLatinStrings(String response, String expected)
    {
        assertThat(expected).isEqualTo(AtbashCode.applyAtbashCode(response));
    }
    @ParameterizedTest
    @CsvSource(value = {"Hello world!, Svool dliow!", "123(), 123()", "2a1, 2z1"})
    @DisplayName("Test strings that contain not latin symbols")
    public void testNotLatinStrings(String response, String expected)
    {
        assertThat(expected).isEqualTo(AtbashCode.applyAtbashCode(response));
    }
    @Test
    @DisplayName("Test when string is null")
    public void testNullStrings()
    {
        String expected = "";

        String response = AtbashCode.applyAtbashCode("");

        assertThat(expected).isEqualTo(AtbashCode.applyAtbashCode(response));
    }
}
