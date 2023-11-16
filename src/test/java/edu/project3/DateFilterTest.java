package edu.project3;

import edu.project3.filters.DateFilter;
import edu.project3.models.Log;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import static org.assertj.core.api.Assertions.assertThat;

public class DateFilterTest {
    DateFilter dateFilter;
    @BeforeEach
    public void createObject() {
        dateFilter = new DateFilter("2022-01-01", "2032-01-01");
    }
    @Test
    @DisplayName("Test date that fits")
    public void testFittingDate() {
        Log log = new Log(null, null, OffsetDateTime.of(LocalDate.now().atStartOfDay(), ZoneOffset.UTC), null, null, null);

        boolean response = dateFilter.isLogFits(log);

        assertThat(response).isTrue();
    }
    @Test
    @DisplayName("Test date that not fits")
    public void testNotFittingDate() {
        Log log = new Log(null, null, OffsetDateTime.of(LocalDate.of(2010, 1, 1).atStartOfDay(), ZoneOffset.UTC), null, null, null);

        boolean response = dateFilter.isLogFits(log);

        assertThat(response).isFalse();
    }
}
