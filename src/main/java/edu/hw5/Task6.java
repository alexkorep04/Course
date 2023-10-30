package edu.hw5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task6 {
    public static boolean isSubsequence(String T, String S) {
        Pattern pattern = Pattern.compile(".*" + Pattern.quote(S) + ".*");
        Matcher matcher = pattern.matcher(T);
        return matcher.find();
    }
}
