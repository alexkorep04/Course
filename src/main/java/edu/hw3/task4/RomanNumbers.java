package edu.hw3.task4;

import java.util.TreeMap;

public class RomanNumbers {

    private static final TreeMap<Integer, String> ROMAN = new TreeMap<>();

    @SuppressWarnings("MagicNumber")

    private RomanNumbers() {
        ROMAN.put(1, "I");
        ROMAN.put(4, "IV");
        ROMAN.put(5, "V");
        ROMAN.put(9, "IX");
        ROMAN.put(10, "X");
        ROMAN.put(40, "XL");
        ROMAN.put(50, "L");
        ROMAN.put(90, "XC");
        ROMAN.put(100, "C");
        ROMAN.put(400, "CD");
        ROMAN.put(500, "D");
        ROMAN.put(900, "CM");
        ROMAN.put(1000, "M");
    }

    @SuppressWarnings("MagicNumber")
    public static String toRoman(int number) {
        if (number < 1 || number > 4000) {
            throw new IllegalArgumentException("Value should be from 1 to 4000");
        }
        int floorValue = ROMAN.floorKey(number);
        if (number == floorValue) {
            return ROMAN.get(number);
        }
        return ROMAN.get(floorValue) + toRoman(number - floorValue);
    }
}
