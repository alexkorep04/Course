package edu.hw9;

import edu.hw9.Task1.Collector;
import edu.hw9.Task1.Type;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.*;
public class Task1Test {
    Collector collector;
    @BeforeEach
    public void createObjects() {
        collector = new Collector(3);
    }

    @Test
    @DisplayName("Test collecting data")
    public void testData() {
        collector.push(Type.MIN, new double[]{4, 1, 0, 3});
        collector.push(Type.MAX, new double[]{4, 1, 0, 3});
        collector.push(Type.AVG, new double[]{4, 1, 0, 3});
        collector.push(Type.SUM, new double[]{4, 1, 0, 3});

        List<Double> expected = List.of(0.0, 4.0, 2.0, 8.0);

        List<Double> response = collector.getAllStatistics();

        assertThat(expected).isEqualTo(response);
    }
}
