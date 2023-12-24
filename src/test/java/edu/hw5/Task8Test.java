package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task8Test {
    @Test
    @DisplayName("Test string with odd length")
    public void testStringWithOddLength() {
        boolean response = Task8.isStringHasOddLength("01101");

        assertThat(response).isTrue();
    }
    @Test
    @DisplayName("Test string with even length")
    public void testStringWithEvenLength() {
        boolean response = Task8.isStringHasOddLength("0110");

        assertThat(response).isFalse();
    }
    @Test
    @DisplayName("Test string with uncorrect alphabet symbols")
    public void testStringWithUncorrectSymbols() {
        boolean response = Task8.isStringHasOddLength("01102");

        assertThat(response).isFalse();
    }
    @Test
    @DisplayName("Test string that has odd length and starts from 0")
    public void testStringWithOddLengthAndStartsWithZero() {
        boolean response = Task8.isStringStartSatisfiesRulesWithFirstSymbolAndLength("01101");

        assertThat(response).isTrue();
    }
    @Test
    @DisplayName("Test string that has even length and starts from 1")
    public void testStringWithEvenLengthAndStartsWithOne() {
        boolean response = Task8.isStringStartSatisfiesRulesWithFirstSymbolAndLength("111010");

        assertThat(response).isTrue();
    }
    @Test
    @DisplayName("Test string that has odd length and starts from 1")
    public void testStringWithOddLengthAndStartsWithOne() {
        boolean response = Task8.isStringStartSatisfiesRulesWithFirstSymbolAndLength("11101");

        assertThat(response).isFalse();
    }
    @Test
    @DisplayName("Test string that has even length and starts from 0")
    public void testStringWithEvenLengthAndStartsWithZeroe() {
        boolean response = Task8.isStringStartSatisfiesRulesWithFirstSymbolAndLength("011010");

        assertThat(response).isFalse();
    }
    @Test
    @DisplayName("Test string 111")
    public void testString111() {
        boolean response = Task8.isStringNot111Or1111("111");

        assertThat(response).isFalse();
    }
    @Test
    @DisplayName("Test string 11")
    public void testString11() {
        boolean response = Task8.isStringNot111Or1111("11");

        assertThat(response).isFalse();
    }
    @Test
    @DisplayName("Test any other string")
    public void testAnyString() {
        boolean response = Task8.isStringNot111Or1111("11111");

        assertThat(response).isTrue();
    }
    @Test
    @DisplayName("Test string with sequential ones")
    public void testStringWithSequentialOnes() {
        boolean response = Task8.isStringNotSequential1("110101");

        assertThat(response).isFalse();
    }
    @Test
    @DisplayName("Test string with not sequential ones")
    public void testStringWithNotSequentialOnes() {
        boolean response = Task8.isStringNotSequential1("10101");

        assertThat(response).isTrue();
    }
}
