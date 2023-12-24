package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class Task2Test {
    @Test
    @DisplayName("Test when difference dates are in one day")
    public void testFindingAllFridaysThe13thInYear() {
        List<LocalDate> expected = new ArrayList<>();
        expected.add(LocalDate.of(2024, 9, 13));
        expected.add(LocalDate.of(2024, 12, 13));

        List<LocalDate> response = Task2.getAllFridaysThe13ByYear(2024);

        assertThat(response).isEqualTo(expected);
    }
    @Test
    @DisplayName("Test of finding next friday the 13th")
    public void testFindingNextFridayThe13th() {
        LocalDate expected = LocalDate.of(2024, 12, 13);

        LocalDate response = Task2.findNextFridayThe13th(LocalDate.of(2024, 10, 1));

        assertThat(response).isEqualTo(expected);
    }
}
