package edu.hw9;

import edu.hw9.Task1.Collector;
import edu.hw9.Task1.Statistics;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import static org.assertj.core.api.Assertions.*;

public class Task1Test {
    @Test
    @DisplayName("Test collector")
    public void testCollector() throws InterruptedException {
        Collector collector = new Collector(4);
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.execute(() -> collector.push("metric1",  new double[]{ 1.0, -1.0, 6.0, 4.1, 5.4}));
        executorService.execute(() -> collector.push("metric2",  new double[]{ -6.7, 5.7, 3.2, -3.2, 1.0}));
        executorService.execute(() -> collector.push("metric3",  new double[]{ -4.7, 5.7, 3.2, -3.2, 1.0}));
        executorService.execute(() -> collector.push("metric4",  new double[]{1.0}));
        Thread.sleep(1000);
        List<Statistics> statistics = collector.getStatistics();

        assertThat(statistics).contains(new Statistics("metric1", -1.0, 6.0, 15.5, 3.1));
        assertThat(statistics).contains(new Statistics("metric2", -6.7, 5.7, 0, 0));
        assertThat(statistics).contains(new Statistics("metric3", -4.7, 5.7, 2, 0.4));
        assertThat(statistics).contains(new Statistics("metric4", 1.0, 1.0, 1.0, 1.0));
    }
}
