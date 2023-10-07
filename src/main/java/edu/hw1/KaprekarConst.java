package edu.hw1;

import java.util.Arrays;

public class KaprekarConst {
    private KaprekarConst() {
    }

    @SuppressWarnings("MagicNumber")

    public static int calculateSteps(Integer n) {
        if (n == 6174) {
            return 0;
        }
        String s = n.toString();
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        String sorted = new String(chars);
        String reverseSorted = new StringBuilder(sorted).reverse().toString();

        int diff = Integer.parseInt(reverseSorted) - Integer.parseInt(sorted);
        return 1 + calculateSteps(diff);
    }
}
