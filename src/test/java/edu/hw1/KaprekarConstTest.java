package edu.hw1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class KaprekarConstTest {
    @Test
    @DisplayName("Simple first test")
    public void testFirstSampleSet()
    {
        int expected = 5;
        int response = KaprekarConst.calculateSteps(6621);
        Assertions.assertEquals(expected, response);
    }
    @Test
    @DisplayName("Simple second test")
    public void testSecondSampleSet()
    {
        int expected = 4;
        int response = KaprekarConst.calculateSteps(6554);
        Assertions.assertEquals(expected, response);
    }
    @Test
    @DisplayName("Simple third test")
    public void testThirdSampleSet()
    {
        int expected = 3;
        int response = KaprekarConst.calculateSteps(1234);
        Assertions.assertEquals(expected, response);
    }
    @Test
    @DisplayName("First input test")
    public void testFirstInput()
    {
        int expected = 0;
        int response = KaprekarConst.calculateSteps(6174);
        Assertions.assertEquals(expected, response);
    }
    @Test
    @DisplayName("Second input test")
    public void testSecondInput()
    {
        int expected = 3;
        int response = KaprekarConst.calculateSteps(3524);
        Assertions.assertEquals(expected, response);
    }
    @Test
    @DisplayName("Third input test")
    public void testThirdInput()
    {
        int expected = 1;
        int response = KaprekarConst.calculateSteps(7641);
        Assertions.assertEquals(expected, response);
    }
    @Test
    @DisplayName("Forth input test")
    public void testForthInput()
    {
        int expected = 4;
        int response = KaprekarConst.calculateSteps(1100);
        Assertions.assertEquals(expected, response);
    }
}
