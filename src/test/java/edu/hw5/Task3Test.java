package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
public class Task3Test {
    @Test
    @DisplayName("Test input date in format YYYY-MM-DD")
    public void testDate1() {
        Optional<LocalDate> expected = Optional.of(LocalDate.of(2020, 10, 10));

        Optional<LocalDate> response = Task3.parseDate("2020-10-10");

        assertThat(response).isEqualTo(expected);
    }
    @Test
    @DisplayName("Test input date in format YYYY-MM-D")
    public void testDate2() {
        Optional<LocalDate> expected = Optional.of(LocalDate.of(2020, 10, 1));

        Optional<LocalDate> response = Task3.parseDate("2020-10-1");

        assertThat(response).isEqualTo(expected);
    }
    @Test
    @DisplayName("Test input date in format DD/MM/YYYY")
    public void testDate3() {
        Optional<LocalDate> expected = Optional.of(LocalDate.of(1976, 3, 11));

        Optional<LocalDate> response = Task3.parseDate("11/3/1976");

        assertThat(response).isEqualTo(expected);
    }
    @Test
    @DisplayName("Test input date in format DD/MM/YY")
    public void testDate4() {
        Optional<LocalDate> expected = Optional.of(LocalDate.of(2020, 3, 1));

        Optional<LocalDate> response = Task3.parseDate("1/3/20");

        assertThat(response).isEqualTo(expected);
    }

    @Test
    @DisplayName("Test input date in format tomorrow")
    public void testDate5() {
        LocalDate date = LocalDate.now();
        date = date.plusDays(1);
        Optional<LocalDate> expected = Optional.of(date);

        Optional<LocalDate> response = Task3.parseDate("tomorrow");

        assertThat(response).isEqualTo(expected);
    }

    @Test
    @DisplayName("Test input date in format today")
    public void testDate6() {
        LocalDate date = LocalDate.now();
        Optional<LocalDate> expected = Optional.of(date);

        Optional<LocalDate> response = Task3.parseDate("today");

        assertThat(response).isEqualTo(expected);
    }

    @Test
    @DisplayName("Test input date in format yesterday")
    public void testDate7() {
        LocalDate date = LocalDate.now();
        date = date.minusDays(1);
        Optional<LocalDate> expected = Optional.of(date);

        Optional<LocalDate> response = Task3.parseDate("yesterday");

        assertThat(response).isEqualTo(expected);
    }

    @Test
    @DisplayName("Test input date in format 1 days ago")
    public void testDate8() {
        LocalDate date = LocalDate.now();
        date = date.minusDays(1);
        Optional<LocalDate> expected = Optional.of(date);

        Optional<LocalDate> response = Task3.parseDate("1 day ago");

        assertThat(response).isEqualTo(expected);
    }
    @Test
    @DisplayName("Test input date in format x days ago")
    public void testDate9() {
        Optional<LocalDate> expected = Optional.of(LocalDate.of(2017, 9, 17));

        Optional<LocalDate> response = Task3.parseDate("2234 days ago");

        assertThat(response).isEqualTo(expected);
    }
    @Test
    @DisplayName("Test uncorrect input date")
    public void testDate10() {
        Optional<LocalDate> expected = Optional.empty();

        Optional<LocalDate> response = Task3.parseDate("2020-10-10-0");

        assertThat(response).isEqualTo(expected);
    }
}
