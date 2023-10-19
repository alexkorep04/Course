package edu.hw3;

import edu.hw3.task3.FrequencyOfObjects;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Map;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test
{
    @Test
    @DisplayName("Test on find frequency of int objects")
    public void testFrequencyOfIntObjects()
    {
        var expected = Map.of(1, 2, 2, 2);

        var response = FrequencyOfObjects.getFrequency(List.of(1, 1, 2, 2));

        assertThat(expected).isEqualTo(response);
    }

    @Test
    @DisplayName("Test on find frequency of string objects")
    public void testFrequencyOfStringObjects()
    {
        var expected = Map.of("hello", 1, "hi", 2, "bye", 1);

        var response = FrequencyOfObjects.getFrequency(List.of("hello", "hi", "bye", "hi"));

        assertThat(expected).isEqualTo(response);
    }

    @Test
    @DisplayName("Test on find frequency of boolean objects")
    public void testFrequencyOfBooleanObjects()
    {
        var expected = Map.of(true, 2, false, 1);

        var response = FrequencyOfObjects.getFrequency(List.of(true, true, false));

        assertThat(expected).isEqualTo(response);
    }
}
