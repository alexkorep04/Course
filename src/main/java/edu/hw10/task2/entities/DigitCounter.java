package edu.hw10.task2.entities;

import edu.hw10.task2.Cache;

public interface DigitCounter {

    @Cache(persist = false)
    int getAmountOfDigits(int number);
}
