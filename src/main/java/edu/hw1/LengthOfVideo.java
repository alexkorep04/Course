package edu.hw1;

public class LengthOfVideo {
    private LengthOfVideo() {
    }

    @SuppressWarnings ("MagicNumber")

    public static int calculateLength(String s) {
        if (s.length() == 0 || s.charAt(0) == ':') {
            return -1;
        }
        for (int i = 0; i < s.length(); i++) {
            char character = s.charAt(i);
            if ((character > '9' || character < '0') && (character != ':')) {
                return -1;
            }
        }
        String[] arr = s.split(":");
        if (arr.length != 2 || arr[0] == null || arr[1] == null) {
            return -1;
        }
        int first = Integer.parseInt(arr[0]);
        int second = Integer.parseInt(arr[1]);
        int ans = 60 * first + second;
        if (second < 0 || second >= 60 || first < 0) {
            ans = -1;
        }
        return ans;
    }
}
