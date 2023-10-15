package edu.hw1;

public class AmountOfDigits {
    private AmountOfDigits() {
    }

    @SuppressWarnings("MagicNumber")

    public static int calculateAmountOfDigits(Integer n) {
        if (n == null) {
            return 0;
        }
        int copy = n;
        int ans = 0;
        if (n == 0) {
            ans++;
        }
        while (copy != 0) {
            ans++;
            copy /= 10;
        }
        return ans;
    }
}
