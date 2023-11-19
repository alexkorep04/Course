package edu.hw8.task2;

import java.util.List;

public class FixedThreadPool implements ThreadPool {
    private final int amountOfThreads;
    private final Thread[] threads;
    private List<Thread>

    public FixedThreadPool(int amountOfThreads) {
        this.amountOfThreads = amountOfThreads;
        threads = new Thread[amountOfThreads];
    }

    @Override
    public void start() {

    }

    @Override
    public void execute(Runnable runnable) {

    }

    @Override
    public void close() throws Exception {

    }
}
