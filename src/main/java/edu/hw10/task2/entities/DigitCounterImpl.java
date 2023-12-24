package edu.hw10.task2.entities;

public class DigitCounterImpl implements DigitCounter {

    @SuppressWarnings("MagicNumber")
    @Override
    public int getAmountOfDigits(int number) {
        if (number == 0) {
            return 1;
        }
        int cnt = 0;
        int copy = number;
        while (copy != 0) {
            cnt++;
            copy /= 10;
        }
        return cnt;
    }
}
