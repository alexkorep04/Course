package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task4Test {
    @Test
    @DisplayName("Test correct password with 1 special symbol")
    public void testCorrectPassword() {
        boolean response = Task4.isCorrectPassword("Passw@");

        assertThat(response).isTrue();
    }
    @Test
    @DisplayName("Test correct password with several special symbol")
    public void testCorrectNotOneSpecialSymbolPassword() {
        boolean response = Task4.isCorrectPassword("Passw@!*|");

        assertThat(response).isTrue();
    }

    @Test
    @DisplayName("Test uncorrect password")
    public void testUncorrectPassword() {
        boolean response = Task4.isCorrectPassword("Passw");

        assertThat(response).isFalse();
    }
}
