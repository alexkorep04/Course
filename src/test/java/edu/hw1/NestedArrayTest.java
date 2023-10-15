package edu.hw1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NestedArrayTest {
    @Test
    @DisplayName("Simple first test")
    public void testFirstSampleSet()
    {
        int[] a = new int[]{1, 2, 3, 4};
        int[] b = new int[]{0, 6};
        boolean expected = true;
        boolean response = NestedArray.isNested(a, b);
        Assertions.assertEquals(expected, response);
    }
    @Test
    @DisplayName("Simple second test")
    public void testSecondSampleSet()
    {
        int[] a = new int[]{3, 1};
        int[] b = new int[]{4, 0};
        boolean expected = true;
        boolean response = NestedArray.isNested(a, b);
        Assertions.assertEquals(expected, response);
    }
    @Test
    @DisplayName("Simple third test")
    public void testThirdSampleSet()
    {
        int[] a = new int[]{9, 9, 8};
        int[] b = new int[]{8, 9};
        boolean expected = false;
        boolean response = NestedArray.isNested(a, b);
        Assertions.assertEquals(expected, response);
    }
    @Test
    @DisplayName("Simple forth test")
    public void testForthSampleSet()
    {
        int[] a = new int[]{1, 2, 3, 4};
        int[] b = new int[]{2, 3};
        boolean expected = false;
        boolean response = NestedArray.isNested(a, b);
        Assertions.assertEquals(expected, response);
    }
    @Test
    @DisplayName("First input test")
    public void testCorrectFirstInput()
    {
        int[] a = new int[]{-100, 212, 1, 0};
        int[] b = new int[]{-2774, 338};
        boolean expected = true;
        boolean response = NestedArray.isNested(a, b);
        Assertions.assertEquals(expected, response);
    }
    @Test
    @DisplayName("Second input test")
    public void testCorrectSecondInput()
    {
        int[] a = new int[]{1, 1};
        int[] b = new int[]{1, 1};
        boolean expected = false;
        boolean response = NestedArray.isNested(a, b);
        Assertions.assertEquals(expected, response);
    }
    @Test
    @DisplayName("Third input test")
    public void testCorrectThirdInput()
    {
        int[] a = new int[]{12, 76, 9};
        int[] b = new int[]{76, 5, 54, 23};
        boolean expected = false;
        boolean response = NestedArray.isNested(a, b);
        Assertions.assertEquals(expected, response);
    }
    @Test
    @DisplayName("First uncorrect input test")
    public void testUncorrectFirstInput()
    {
        int[] a = new int[]{};
        int[] b = new int[]{76, 5, 54, 23};
        boolean expected = true;
        boolean response = NestedArray.isNested(a, b);
        Assertions.assertEquals(expected, response);
    }
    @Test
    @DisplayName("Second uncorrect input test")
    public void testUncorrectSecondInput()
    {
        int[] a = new int[]{1, 2};
        int[] b = new int[]{};
        boolean expected = false;
        boolean response = NestedArray.isNested(a, b);
        Assertions.assertEquals(expected, response);
    }
    @Test
    @DisplayName("Third uncorrect input test")
    public void testUncorrectThirdInput()
    {
        int[] a = new int[]{};
        int[] b = new int[]{};
        boolean expected = false;
        boolean response = NestedArray.isNested(a, b);
        Assertions.assertEquals(expected, response);
    }
}
