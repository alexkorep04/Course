package edu.hw5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task7 {
    public static boolean isCorrectString(String input) {
        Pattern pattern = Pattern.compile("^0[0|1]0$");
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }
}
