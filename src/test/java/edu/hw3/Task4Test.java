package edu.hw3;

import edu.hw3.task1.AtbashCode;
import edu.hw3.task4.RomanNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

public class Task4Test {
    @ParameterizedTest
    @CsvSource(value = {"1, I", "16, XVI", "4000, MMMM", "2208, MMCCVIII"})
    @DisplayName("Test correct arabic numbers")
    public void testNotLatinStrings(int response, String expected)
    {
        assertThat(RomanNumbers.toRoman(response)).isEqualTo(expected);
    }
    @Test
    @DisplayName("Test uncorrect arabic numbers")
    public void testNotLatinStrings()
    {
        assertThatThrownBy(() -> RomanNumbers.toRoman(4001)).isInstanceOf(IllegalArgumentException.class);
    }

}
