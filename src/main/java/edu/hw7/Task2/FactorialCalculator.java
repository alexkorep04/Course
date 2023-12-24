package edu.hw7.Task2;

import java.util.ArrayList;
import java.util.List;

public class FactorialCalculator {
    private long num;

    public FactorialCalculator(long num) {
        this.num = num;
    }

    @SuppressWarnings("MagicNumber")
    public long calculateFactorial() {
        if (num < 0 || num > 19) {
            throw new IllegalArgumentException("Argument is not correct!");
        }
        if (num == 0) {
            return 1;
        }
        List<Long> numsBetween = new ArrayList<>();
        for (long i = 1; i <= num; i++) {
            numsBetween.add(i);
        }
        return numsBetween.parallelStream().reduce((a, b) -> (a * b)).get();
    }
}
