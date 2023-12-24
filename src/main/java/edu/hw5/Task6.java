package edu.hw5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task6 {
    private Task6() {
    }

    public static boolean isSubsequence(String t, String s) {
        Pattern pattern = Pattern.compile(".*" + Pattern.quote(s) + ".*");
        Matcher matcher = pattern.matcher(t);
        return matcher.find();
    }
}
