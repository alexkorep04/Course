package edu.hw7.Task1;

import java.util.concurrent.atomic.AtomicInteger;

public class IncrementClass {
    private static AtomicInteger counter = new AtomicInteger(0);
    public AtomicInteger incrementCounter() {
        Thread thread1 = new Thread(new ThreadClass(counter));
        Thread thread2 = new Thread(new ThreadClass(counter));
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return counter;
    }
}
