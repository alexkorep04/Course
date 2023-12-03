package edu.hw9.Task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Collector {
    private ExecutorService executorService;
    private final Lock lock = new ReentrantLock();
    private static final ReadWriteLock reentrantLock = new ReentrantReadWriteLock();
    private final int amountOfThreads;
    private List<Double> allStatistics;

    public Collector(int amountOfThreads) {
        this.amountOfThreads = amountOfThreads;
        executorService = Executors.newFixedThreadPool(amountOfThreads);
        allStatistics = new ArrayList<>();
    }

    public void push(Type type, double[] data) {
        int cnt;
        lock.lock();
        try {
            cnt = allStatistics.size();
            allStatistics.add(0.0);
        } finally {
            lock.unlock();
        }
        executorService.execute(() -> {
            reentrantLock.writeLock().lock();
            try {
                if(Type.MAX.equals(type)) {
                    allStatistics.set(cnt, getMax(data));
                } else if(Type.MIN.equals(type)) {
                    allStatistics.set(cnt, getMin(data));
                } else if(Type.SUM.equals(type)) {
                    allStatistics.set(cnt, getSum(data));
                } else {
                    allStatistics.set(cnt, getAvg(data));
                }
            } finally {
                reentrantLock.writeLock().unlock();
            }
        });
    }

    public List<Double> getAllStatistics() {
        reentrantLock.readLock().lock();
        try {
            Thread.sleep(100);
            executorService.shutdown();
            return allStatistics;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            reentrantLock.readLock().unlock();
        }
    }

    private double getMax(double[] data) {
        return Arrays.stream(data).max().orElse(0.0);
    }

    private double getMin(double[] data) {
        return Arrays.stream(data).min().orElse(0.0);
    }

    private double getSum(double[] data) {
        return Arrays.stream(data).sum();
    }

    private double getAvg(double[] data) {
        return Arrays.stream(data).average().orElse(0.0);
    }

}
