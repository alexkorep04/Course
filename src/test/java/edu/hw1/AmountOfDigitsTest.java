package edu.hw1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AmountOfDigitsTest {
    @Test
    @DisplayName("Simple first test")
    public void testFirstSampleSet()
    {
        int expected = 4;
        int response = AmountOfDigits.calculateAmountOfDigits(4666);
        Assertions.assertEquals(expected, response);
    }
    @Test
    @DisplayName("Simple second test")
    public void testSecondSampleSet()
    {
        int expected = 3;
        int response = AmountOfDigits.calculateAmountOfDigits(544);
        Assertions.assertEquals(expected, response);
    }
    @Test
    @DisplayName("Simple third test")
    public void testThirdSampleSet()
    {
        int expected = 1;
        int response = AmountOfDigits.calculateAmountOfDigits(0);
        Assertions.assertEquals(expected, response);
    }
    @Test
    @DisplayName("First input test")
    public void testFirstInput()
    {
        int expected = 8;
        int response = AmountOfDigits.calculateAmountOfDigits(57312636);
        Assertions.assertEquals(expected, response);
    }
    @Test
    @DisplayName("Second input test")
    public void testSecondInput()
    {
        int expected = 1;
        int response = AmountOfDigits.calculateAmountOfDigits(3);
        Assertions.assertEquals(expected, response);
    }
    @Test
    @DisplayName("Third input test")
    public void testthirdInput()
    {
        int expected = 3;
        int response = AmountOfDigits.calculateAmountOfDigits(-321);
        Assertions.assertEquals(expected, response);
    }
    @Test
    @DisplayName("Forth input test")
    public void testForthInput()
    {
        int expected = 5;
        int response = AmountOfDigits.calculateAmountOfDigits(-24371);
        Assertions.assertEquals(expected, response);
    }
    @Test
    @DisplayName("Sixth input test")
    public void testSixthInput()
    {
        int expected = 0;
        int response = AmountOfDigits.calculateAmountOfDigits(null);
        Assertions.assertEquals(expected, response);
    }
}
