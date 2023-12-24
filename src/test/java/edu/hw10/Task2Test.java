package edu.hw10;

import edu.hw10.task2.CacheProxy;
import edu.hw10.task2.entities.DigitCounter;
import edu.hw10.task2.entities.DigitCounterImpl;
import edu.hw10.task2.entities.FibCalculator;
import edu.hw10.task2.entities.FibCalculatorImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class Task2Test {
    @Test
    @DisplayName("Test fibonacci persist = true")
    public void testFibPersistTrue() {
        FibCalculator fibCalculator = CacheProxy.create(new FibCalculatorImpl(), FibCalculatorImpl.class);

        long expected = 55L;

        assertThat(expected).isEqualTo(fibCalculator.fib(10));
        assertThat(expected).isEqualTo(fibCalculator.fib(10));

        expected = 21L;

        assertThat(expected).isEqualTo(fibCalculator.fib(8));
        assertThat(expected).isEqualTo(fibCalculator.fib(8));
    }

    @Test
    @DisplayName("Test digit counter persist = false")
    public void testDigCounterPersistFalse() {
        DigitCounter digitCounter = CacheProxy.create(new DigitCounterImpl(), DigitCounterImpl.class);

        int expected = 3;

        assertThat(expected).isEqualTo(digitCounter.getAmountOfDigits(123));
        assertThat(expected).isEqualTo(digitCounter.getAmountOfDigits(123));

        expected = 2;
        assertThat(expected).isEqualTo(digitCounter.getAmountOfDigits(12));
        assertThat(expected).isEqualTo(digitCounter.getAmountOfDigits(12));

        expected = 1;
        assertThat(expected).isEqualTo(digitCounter.getAmountOfDigits(0));
        assertThat(expected).isEqualTo(digitCounter.getAmountOfDigits(0));
    }
}
