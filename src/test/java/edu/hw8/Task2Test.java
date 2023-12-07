package edu.hw8;

import edu.hw8.task2.FixedThreadPool;
import edu.hw8.task2.ThreadPool;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {
    public static long calculateFibonacci(int n) {
        if(n < 0) {
            throw new RuntimeException();
        }
        if(n == 0) {
            return 0;
        }
        long cur1 = 0;
        long cur2 = 1;
        for (int i = 2; i <= n; i++) {
            long temp = cur2;
            cur2 += cur1;
            cur1 = temp;
        }
        return cur2;
    }
    @Test
    @DisplayName("Test on Fibonacchi")
    public void testFib() {
        List<Long> expected = List.of(1L, 1L, 2L, 3L, 5L, 8L, 13L, 21L, 34L, 55L);
        List<Long> response = new ArrayList<>();
        try (ThreadPool threadPool = FixedThreadPool.create(5)) {
            threadPool.start();
            for (int i = 1; i <= 10; i++) {
                final int index = i;
                List<Long> finalResponse = response;
                threadPool.execute(() -> {
                    long result = calculateFibonacci(index);
                    finalResponse.add(result);
                });
            }
            Thread.sleep(1000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        response = response.stream().sorted().toList();

        assertThat(expected).isEqualTo(response);
    }
}

