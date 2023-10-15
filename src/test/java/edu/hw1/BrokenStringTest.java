package edu.hw1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BrokenStringTest {
    @Test
    @DisplayName("Simple first test")
    public void testFirstSampleSet()
    {
        String expected = "214365";
        String response = BrokenString.fixString("123456");
        Assertions.assertEquals(expected, response);
    }
    @Test
    @DisplayName("Simple second test")
    public void testSecondSampleSet()
    {
        String expected = "This is a mixed up string.";
        String response = BrokenString.fixString("hTsii  s aimex dpus rtni.g");
        Assertions.assertEquals(expected, response);
    }
    @Test
    @DisplayName("Simple third test")
    public void testThirdSampleSet()
    {
        String expected = "abcde";
        String response = BrokenString.fixString("badce");
        Assertions.assertEquals(expected, response);
    }
    @Test
    @DisplayName("First input test")
    public void testFirstInput()
    {
        String expected = "a";
        String response = BrokenString.fixString("a");
        Assertions.assertEquals(expected, response);
    }
    @Test
    @DisplayName("Second input test")
    public void testSecondInput()
    {
        String expected = "";
        String response = BrokenString.fixString("");
        Assertions.assertEquals(expected, response);
    }
    @Test
    @DisplayName("Third input test")
    public void testThirdInput()
    {
        String expected = "dkdhjs72bd";
        String response = BrokenString.fixString("kdhdsj27db");
        Assertions.assertEquals(expected, response);
    }
}
