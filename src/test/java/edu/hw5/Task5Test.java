package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task5Test {
    @Test
    @DisplayName("Test correct number")
    public void testCorrectNumber() {
        boolean response = Task5.isCorrectNumber("А123ВЕ777");

        assertThat(response).isTrue();
    }
    @Test
    @DisplayName("Test uncorrect number that is too long")
    public void testUncorrectNumberThatIsTooLong() {
        boolean response = Task5.isCorrectNumber("А123ВЕ7777");

        assertThat(response).isFalse();
    }

    @Test
    @DisplayName("Test uncorrect number does not match the pattern")
    public void testUncorrectNumberThatDoesNotMatchPattern() {
        boolean response = Task5.isCorrectNumber("А12ВЕ777");

        assertThat(response).isFalse();
    }
}
