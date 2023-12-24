package edu.hw7.Task1;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadClass extends Thread {
    private AtomicInteger counter;

    public ThreadClass(AtomicInteger counter) {
        this.counter = counter;
    }

    @SuppressWarnings("MagicNumber")

    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            counter.incrementAndGet();
        }
    }
}
