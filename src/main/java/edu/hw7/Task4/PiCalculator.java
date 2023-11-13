package edu.hw7.Task4;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class PiCalculator {
    private int iterations;
    public PiCalculator(int iterations) {
        this.iterations = iterations;
    }

    public double calculatePiValue() {
        if(iterations < 10000) {
            throw new IllegalArgumentException("Too small amount of iterations!");
        }
        int numThreads = 10;
        Thread[] threads = new Thread[numThreads];
        AtomicInteger totalCount = new AtomicInteger(0);
        AtomicInteger circleCount = new AtomicInteger(0);
        for(int i = 0; i < numThreads; i++) {
            threads[i] = new Thread(() -> {
                Random random = new Random();
                int localCircleCount = 0;
                int localTotalCount = 0;
                for (int j = 0; j < iterations / numThreads; j++) {
                    double x = random.nextDouble();
                    double y = random.nextDouble();
                    if (Math.pow((x - 0.5), 2) + Math.pow((y - 0.5), 2) <= 0.25) {
                        localCircleCount++;
                    }
                    localTotalCount++;
                }
                totalCount.addAndGet(localTotalCount);
                circleCount.addAndGet(localCircleCount);
            });
            threads[i].start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        double pi = 4.0 * circleCount.get() / totalCount.get();
        return pi;
    }
}
//время для 10000: для однопоточного режима с обыным int - 1 миллисекунд, для 10 многопоточного с 10 потоками и атомиками - 3 миллисекунд
//время для 100000: для однопоточного режима с обыным int - 8 миллисекунд, для 10 многопоточного с 10 потоками и атомиками - 8 миллисекунд
//время для 1000000: для однопоточного режима с обыным int - 43 миллисекунд, для 10 многопоточного с 10 потоками и атомиками - 42 миллисекунд
//время для 10000000: для однопоточного режима с обыным int - 395 миллисекунд, для 10 многопоточного с 10 потоками и атомиками - 69 миллисекунд
//погрешность для 10000: - 0.0416
//погрешность для 100000: - 0.0146
//погрешность для 1000000: - 0.00654
//погрешность для 10000000: - 0.00164
