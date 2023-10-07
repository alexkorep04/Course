package edu.hw1;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
public class LengthOfVideoTest {
    @Test
    @DisplayName("Simple first test")
    public void testFirstSampleSet()
    {
        int expected = 60;
        int response = LengthOfVideo.calculateLength("01:00");
        Assertions.assertEquals(expected, response);
    }
    @Test
    @DisplayName("Simple second test")
    public void testSecondSampleSet()
    {
        int expected = 836;
        int response = LengthOfVideo.calculateLength("13:56");
        Assertions.assertEquals(expected, response);
    }
    @Test
    @DisplayName("Simple third test")
    public void testThirdSampleSet()
    {
        int expected = -1;
        int response = LengthOfVideo.calculateLength("10:60");
        Assertions.assertEquals(expected, response);
    }
    @Test
    @DisplayName("First correct input test")
    public void testCorrectFirstInput()
    {
        int expected = 34734;
        int response = LengthOfVideo.calculateLength("578:54");
        Assertions.assertEquals(expected, response);
    }
    @Test
    @DisplayName("Second correct  input test")
    public void testCorrectSecondInput()
    {
        int expected = 0;
        int response = LengthOfVideo.calculateLength("00:00");
        Assertions.assertEquals(expected, response);
    }
    @Test
    @DisplayName("Third correct input test")
    public void testCorrectThirdInput()
    {
        int expected = 321;
        int response = LengthOfVideo.calculateLength("5:21");
        Assertions.assertEquals(expected, response);
    }
    @Test
    @DisplayName("First uncorrect input test")
    public void testUncorrectFirstInput()
    {
        int expected = -1;
        int response = LengthOfVideo.calculateLength("-1:21");
        Assertions.assertEquals(expected, response);
    }
    @Test
    @DisplayName("Second uncorrect input test")
    public void testUncorrectSecondInput()
    {
        int expected = -1;
        int response = LengthOfVideo.calculateLength("aboba");
        Assertions.assertEquals(expected, response);
    }
    @Test
    @DisplayName("Third uncorrect input test")
    public void testUncorrectThirdInput()
    {
        int expected = -1;
        int response = LengthOfVideo.calculateLength("98:21:65");
        Assertions.assertEquals(expected, response);
    }
    @Test
    @DisplayName("Forth uncorrect input test")
    public void testUncorrectForthInput()
    {
        int expected = -1;
        int response = LengthOfVideo.calculateLength("999:60");
        Assertions.assertEquals(expected, response);
    }
    @Test
    @DisplayName("Fifth uncorrect input test")
    public void testUncorrectFifthInput()
    {
        int expected = -1;
        int response = LengthOfVideo.calculateLength("999:");
        Assertions.assertEquals(expected, response);
    }
    @Test
    @DisplayName("Sixth uncorrect input test")
    public void testUncorrectSixthInput()
    {
        int expected = -1;
        int response = LengthOfVideo.calculateLength(":54");
        Assertions.assertEquals(expected, response);
    }
    @Test
    @DisplayName("Seventh uncorrect input test")
    public void testUncorrectSeventhInput()
    {
        int expected = -1;
        int response = LengthOfVideo.calculateLength("");
        Assertions.assertEquals(expected, response);
    }
}
