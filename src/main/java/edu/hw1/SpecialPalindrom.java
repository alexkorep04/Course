package edu.hw1;

public class SpecialPalindrom {
    private SpecialPalindrom() {
    }

    private static boolean isPalindrom(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    private static String getNextGeneration(String numStr) {
        StringBuilder nextGen = new StringBuilder();
        for (int i = 0; i < numStr.length() - 1; i += 2) {
            int digit1 = Character.getNumericValue(numStr.charAt(i));
            int digit2 = Character.getNumericValue(numStr.charAt(i + 1));
            int sum = digit1 + digit2;
            nextGen.append(sum);
        }
        if (numStr.length() % 2 == 1) {
            nextGen.append(numStr.charAt(numStr.length() - 1));
        }
        return nextGen.toString();
    }

    public static boolean checkNumForPalindrom(Integer n) {
        if (n == null) {
            return false;
        }
        String string = n.toString();
        if (isPalindrom(n.toString()) && string.length() > 1) {
            return true;
        }
        while (string.length() > 1) {
            string = getNextGeneration(string);
            if (isPalindrom(string) && string.length() > 1) {
                return true;
            }
        }
        return false;
    }
}
