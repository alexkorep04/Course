package edu.hw5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task8 {
    public static boolean isStringHasOddLength(String input) {
        Pattern pattern = Pattern.compile("^([0|1][0|1])*[0|1]$");
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }
    public static boolean isStringStartSatisfiesRulesWithFirstSymbolAndLength(String input) {
        Pattern pattern = Pattern.compile("^0([0|1][0|1])*$|^1([0|1][0|1])*[0|1]$");
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }
    public static boolean isStringNot111Or1111(String input) {
        Pattern pattern = Pattern.compile("^(?!11$|111$).*$");
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }
    public static boolean isStringNotSequential1(String input) {
        Pattern pattern = Pattern.compile("^(?!.*11).*$");
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }
}
