package edu.hw1;


public class LengthOfVideo {
    private LengthOfVideo() {
    }

    @SuppressWarnings("MagicNumber")

    public static int calculateLength(String s) {
        boolean fl = true;
        if (s.length() == 0 || s.charAt(0) == ':') {
            fl = false;
        }
        for (int i = 0; i < s.length(); i++) {
            char character = s.charAt(i);
            if ((character > '9' || character < '0') && character != ':') {
                fl = false;
            }
        }
        if (!fl) {
            return -1;
        }
        String[] arr = s.split(":");
        if (arr.length != 2 || arr[0] == null || arr[1] == null) {
            return -1;
        }
        int first = Integer.parseInt(arr[0]);
        int second = Integer.parseInt(arr[1]);
        if (second < 0 || second >= 60 || first < 0) {
            return -1;
        }
        int ans = 60 * first + second;
        return ans;
    }
}
