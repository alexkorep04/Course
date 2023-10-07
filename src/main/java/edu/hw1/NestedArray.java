package edu.hw1;

public class NestedArray {
    private NestedArray() {
    }

    public static boolean isNested(int[] a, int[] b) {
        if ((a.length == 0 && b.length == 0) || (b.length == 0)) {
            return false;
        }
        if (a.length == 0) {
            return true;
        }
        int maxA = Integer.MIN_VALUE;
        int maxB = Integer.MIN_VALUE;
        int minA = Integer.MAX_VALUE;
        int minB = Integer.MAX_VALUE;
        for (Integer el : a) {
            maxA = Math.max(el, maxA);
            minA = Math.min(el, minA);
        }
        for (Integer el : b) {
            maxB = Math.max(el, maxB);
            minB = Math.min(el, minB);
        }
        if (minA > minB && maxA < maxB) {
            return true;
        }
        return false;
    }
}
