package edu.hw1;

public class CyclicShift {
    private CyclicShift() {
    }

    private static int amountOfBinaryDigitsInNum(int n) {
        int ans = 0;
        int copy = n;
        while (copy > 0) {
            ans++;
            copy /= 2;
        }
        return ans;
    }

    public static int rotateLeft(int n, int shift) {
        int bits = amountOfBinaryDigitsInNum(n);
        int intMask = (1 << bits) - 1;
        return intMask & ((n << shift % bits) | (n >>> (bits - shift % bits)));
    }

    public static int rotateRight(int n, int shift) {
        int bits = amountOfBinaryDigitsInNum(n);
        int intMask = (1 << bits) - 1;
        return intMask & ((n << (bits - shift % bits)) | (n >>> shift % bits));
    }
}
