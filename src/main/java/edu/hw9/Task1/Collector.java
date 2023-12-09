package edu.hw9.Task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Collector {
    private final int amountOfTreads;
    private final ExecutorService service;
    AtomicInteger atomicInteger;
    private List<Statistics> statistics;

    public Collector(int amountOfTreads) {
        this.amountOfTreads = amountOfTreads;
        service = Executors.newFixedThreadPool(amountOfTreads);
        statistics = new ArrayList<>();
        atomicInteger = new AtomicInteger(0);
    }

    public void push(String name, double[] stats) {
        if (!service.isShutdown()) {
            atomicInteger.incrementAndGet();
            service.execute(() -> {
                statistics.add(new Statistics(name, getMin(stats), getMax(stats), getSum(stats), getAvg(stats)));
                atomicInteger.decrementAndGet();
            });
        }
    }

    public List<Statistics> getStatistics() throws InterruptedException {
        while (atomicInteger.get() != 0) {
        }
        service.shutdown();
        return statistics;
    }

    private double getMax(double[] stats) {
        return Arrays.stream(stats).max().getAsDouble();
    }

    private double getMin(double[] stats) {
        return Arrays.stream(stats).min().getAsDouble();
    }

    private double getSum(double[] stats) {
        return Arrays.stream(stats).sum();
    }

    private double getAvg(double[] stats) {
        return Arrays.stream(stats).average().getAsDouble();
    }
}
