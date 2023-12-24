package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task7Test {
    @Test
    @DisplayName("Test string has equal first and last symbol")
    public void testStringHasEqualFirstAndLastSymbol() {
        boolean response = Task7.isStringHasEqualFirstAndLastSymbol("001100");

        assertThat(response).isTrue();
    }
    @Test
    @DisplayName("Test string has not equal first and last symbol")
    public void testStringHasNotEqualFirstAndLastSymbol() {
        boolean response = Task7.isStringHasEqualFirstAndLastSymbol("001101");

        assertThat(response).isFalse();
    }

    @Test
    @DisplayName("Test string has equal first and last symbol, but has not alphabet symbols")
    public void testStringHasEqualFirstAndLastSymbolButHasUncorrectSymbols() {
        boolean response = Task7.isStringHasEqualFirstAndLastSymbol("101121");

        assertThat(response).isFalse();
    }
    @Test
    @DisplayName("Test string that has length three and third is zero")
    public void testStringHasLengthThreeAndThirdIsZero() {
        boolean response = Task7.isStringHasLengthMoreThanThreeAndThirdIsZero("100");

        assertThat(response).isTrue();
    }
    @Test
    @DisplayName("Test string that has length three and third is not zero")
    public void testStringHasLengthThreeAndThirdIsNotZero() {
        boolean response = Task7.isStringHasLengthMoreThanThreeAndThirdIsZero("101");

        assertThat(response).isFalse();
    }
    @Test
    @DisplayName("Test string that has not length more than three")
    public void testStringHasNotLengthThree() {
        boolean response = Task7.isStringHasLengthMoreThanThreeAndThirdIsZero("10");

        assertThat(response).isFalse();
    }
    @Test
    @DisplayName("Test string that has length from one to three")
    public void testStringHasLengthFromOneToThree() {
        boolean response = Task7.isStringHasLengthFromOneToThree("10");

        assertThat(response).isTrue();
    }

    @Test
    @DisplayName("Test string that has length from one to three")
    public void testStringHasNotLengthFromOneToThree() {
        boolean response = Task7.isStringHasLengthFromOneToThree("1011");

        assertThat(response).isFalse();
    }
}
