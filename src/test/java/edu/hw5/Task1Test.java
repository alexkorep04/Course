package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
public class Task1Test {
    @Test
    @DisplayName("Test when difference dates are in one day")
    public void testDifferenceOfDatesDuringOneDay() {
        String expected = "8h 3m";

        String response = Task1.countDifferenceBetweenTime(new String[]{"2022-03-12, 20:20 - 2022-03-12, 23:50", "2022-03-11, 00:20 - 2022-03-11, 12:56"});

        assertThat(response).isEqualTo(expected);
    }
    @Test
    @DisplayName("Test when difference dates are in different day")
    public void testDifferenceOfDatesDuringDifferentDay() {
        String expected = "2h 43m";

        String response = Task1.countDifferenceBetweenTime(new String[]{"2022-03-12, 20:20 - 2022-03-13, 00:10", "2022-03-11, 23:20 - 2022-03-12, 01:00", "2022-03-11, 22:20 - 2022-03-12, 01:00"});

        assertThat(response).isEqualTo(expected);
    }
}
