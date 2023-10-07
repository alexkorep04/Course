package edu.hw1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SpecialPalindomTest {
    @Test
    @DisplayName("Simple first test")
    public void testFirstSampleSet()
    {
        boolean expected = true;
        boolean response = SpecialPalindrom.checkNumForPalindrom(11211230);
        Assertions.assertEquals(expected, response);
    }
    @Test
    @DisplayName("Simple second test")
    public void testSecondSampleSet()
    {
        boolean expected = true;
        boolean response = SpecialPalindrom.checkNumForPalindrom(13001120);
        Assertions.assertEquals(expected, response);
    }
    @Test
    @DisplayName("Simple third test")
    public void testThirdSampleSet()
    {
        boolean expected = true;
        boolean response = SpecialPalindrom.checkNumForPalindrom(23336014);
        Assertions.assertEquals(expected, response);
    }
    @Test
    @DisplayName("Simple forth test")
    public void testForthSampleSet()
    {
        boolean expected = true;
        boolean response = SpecialPalindrom.checkNumForPalindrom(11);
        Assertions.assertEquals(expected, response);
    }
    @Test
    @DisplayName("First input test")
    public void testFirstInput()
    {
        boolean expected = false;
        boolean response = SpecialPalindrom.checkNumForPalindrom(5);
        Assertions.assertEquals(expected, response);
    }
    @Test
    @DisplayName("Second input test")
    public void testSecondInput()
    {
        boolean expected = false;
        boolean response = SpecialPalindrom.checkNumForPalindrom(0);
        Assertions.assertEquals(expected, response);
    }
    @Test
    @DisplayName("Third input test")
    public void testThirdInput()
    {
        boolean expected = false;
        boolean response = SpecialPalindrom.checkNumForPalindrom(null);
        Assertions.assertEquals(expected, response);
    }
    @Test
    @DisplayName("Forth input test")
    public void testForthInput()
    {
        boolean expected = true;
        boolean response = SpecialPalindrom.checkNumForPalindrom(9999);
        Assertions.assertEquals(expected, response);
    }
    @Test
    @DisplayName("Fifth input test")
    public void testFifthInput()
    {
        boolean expected = false;
        boolean response = SpecialPalindrom.checkNumForPalindrom(1597068);
        Assertions.assertEquals(expected, response);
    }
    @Test
    @DisplayName("Sixth input test")
    public void testSixthInput()
    {
        boolean expected = true;
        boolean response = SpecialPalindrom.checkNumForPalindrom(14231450);
        Assertions.assertEquals(expected, response);
    }
}
