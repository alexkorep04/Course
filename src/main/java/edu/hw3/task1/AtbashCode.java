package edu.hw3.task1;

public class AtbashCode {
    private AtbashCode() {
    }

    public static String applyAtbashCode(String input) {
        if (input == null) {
            return "";
        }
        StringBuilder ans = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                char mirroredChar = (char) (base + ('z' - Character.toLowerCase(c)));
                ans.append(Character.isUpperCase(c) ? Character.toUpperCase(mirroredChar) : mirroredChar);
            } else {
                ans.append(c);
            }
        }
        return ans.toString();
    }
}
