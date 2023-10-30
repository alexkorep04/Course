package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task7Test {
    @Test
    @DisplayName("Test correct string")
    public void testCorrectString() {
        boolean response = Task7.isCorrectString("010");

        assertThat(response).isTrue();
    }
    @Test
    @DisplayName("Test uncorrect string with big length")
    public void testUncorrectString() {
        boolean response = Task7.isCorrectString("0101");

        assertThat(response).isFalse();
    }
    @Test
    @DisplayName("Test uncorrect string with uncorrect third symbol")
    public void testUncorrectStringWithWrongThirdSymbol() {
        boolean response = Task7.isCorrectString("011");

        assertThat(response).isFalse();
    }

}
