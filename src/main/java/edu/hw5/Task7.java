package edu.hw5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task7 {
    private Task7() {
    }

    public static boolean isStringHasLengthMoreThanThreeAndThirdIsZero(String input) {
        Pattern pattern = Pattern.compile("^[0|1][0|1]0[0,1]{0,}");
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }

    public static boolean isStringHasEqualFirstAndLastSymbol(String input) {
        Pattern pattern = Pattern.compile("^([0|1])[0|1]*\\1$");
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }

    public static boolean isStringHasLengthFromOneToThree(String input) {
        Pattern pattern = Pattern.compile("^[0|1]{1,3}$");
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }
}
