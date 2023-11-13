package edu.hw7;

import edu.hw7.Task2.FactorialCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task2Test {
    @Test
    @DisplayName("Test calculating factorial")
    public void testFactorial() {
        FactorialCalculator factorialCalculator = new FactorialCalculator(6);

        var expected = 720;

        var response = factorialCalculator.calculateFactorial();

        assertThat(expected).isEqualTo(response);
    }
    @Test
    @DisplayName("Test calculating factorial on not correct data")
    public void testFactorialOnUncorrectData() {
        FactorialCalculator factorialCalculator = new FactorialCalculator(20);

        assertThrows(IllegalArgumentException.class, factorialCalculator::calculateFactorial);
    }
}
