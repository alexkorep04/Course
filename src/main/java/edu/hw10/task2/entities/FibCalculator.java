package edu.hw10.task2.entities;

import edu.hw10.task2.Cache;

public interface FibCalculator {

    @Cache(persist = true)
    long fib(int number);
}
