package edu.hw3.task4;

import java.util.TreeMap;

public class RomanNumbers {
    private static final TreeMap<Integer, String> romanNumerals = new TreeMap<>();
    static {
        romanNumerals.put(1, "I");
        romanNumerals.put(4, "IV");
        romanNumerals.put(5, "V");
        romanNumerals.put(9, "IX");
        romanNumerals.put(10, "X");
        romanNumerals.put(40, "XL");
        romanNumerals.put(50, "L");
        romanNumerals.put(90, "XC");
        romanNumerals.put(100, "C");
        romanNumerals.put(400, "CD");
        romanNumerals.put(500, "D");
        romanNumerals.put(900, "CM");
        romanNumerals.put(1000, "M");
    }
    public static String toRoman(int number) {
        if(number < 1 || number > 4000) {
            throw new IllegalArgumentException("Value should be from 1 to 4000");
        }
        int floorValue = romanNumerals.floorKey(number);
        if (number == floorValue) {
            return romanNumerals.get(number);
        }
        return romanNumerals.get(floorValue) + toRoman(number - floorValue);
    }

    public static void main(String[] args) {
        int arabicNumber = 4001;
        String romanNumber = toRoman(arabicNumber);
        System.out.println(romanNumber);
    }
}
