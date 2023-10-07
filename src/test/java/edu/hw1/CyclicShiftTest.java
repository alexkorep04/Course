package edu.hw1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CyclicShiftTest {
    @Test
    @DisplayName("Simple first test")
    public void testFirstSampleSet()
    {
        int expected = 4;
        int response = CyclicShift.rotateRight(8, 1);
        Assertions.assertEquals(expected, response);
    }
    @Test
    @DisplayName("Simple second test")
    public void testSecondSampleSet()
    {
        int expected = 1;
        int response = CyclicShift.rotateLeft(16, 1);
        Assertions.assertEquals(expected, response);
    }
    @Test
    @DisplayName("Simple third test")
    public void testThirdSampleSet()
    {
        int expected = 6;
        int response = CyclicShift.rotateLeft(17, 2);
        Assertions.assertEquals(expected, response);
    }
    @Test
    @DisplayName("First input test")
    public void testFirstInput()
    {
        int expected = 15;
        int response = CyclicShift.rotateLeft(15, 5);
        Assertions.assertEquals(expected, response);
    }
    @Test
    @DisplayName("Second input test")
    public void testSecondInput()
    {
        int expected = 1;
        int response = CyclicShift.rotateLeft(1, 50);
        Assertions.assertEquals(expected, response);
    }
    @Test
    @DisplayName("Third input test")
    public void testThirdInput()
    {
        int expected = 3;
        int response = CyclicShift.rotateRight(24, 3);
        Assertions.assertEquals(expected, response);
    }
    @Test
    @DisplayName("Forth input test")
    public void testForthInput()
    {
        int expected = 1;
        int response = CyclicShift.rotateRight(1, 50);
        Assertions.assertEquals(expected, response);
    }
    @Test
    @DisplayName("Fifth input test")
    public void testFifthInput()
    {
        int expected = 15;
        int response = CyclicShift.rotateRight(15, 5);
        Assertions.assertEquals(expected, response);
    }
}
