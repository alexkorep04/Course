package edu.hw5;

import java.time.Duration;
import java.time.LocalDateTime;

public class Task1 {
    public static String countDifferenceBetweenTime(String[] input) {
        long second = 0;
        for (String s: input) {
            String[] parts = s.split(" - ");
            String day1 = parts[0].split(", ")[0];
            String hoursAndMinutes1 = parts[0].split(", ")[1];
            String day2 = parts[1].split(", ")[0];
            String hoursAndMinutes2 = parts[1].split(", ")[1];
            String time1 = day1 + "T" + hoursAndMinutes1;
            String time2 = day2 + "T" + hoursAndMinutes2;
            LocalDateTime start = LocalDateTime.parse(time1);
            LocalDateTime end = LocalDateTime.parse(time2);
            second += Duration.between(start, end).getSeconds();
        }
        long middleSeconds = second / input.length;
        return Long.toString(middleSeconds / 3600) + "h " + Long.toString((middleSeconds - middleSeconds / 3600 * 3600) / 60) + "m";
    }

    public static void main(String[] args) {
        System.out.println(countDifferenceBetweenTime(new String[]{"2022-04-01, 21:30 - 2022-04-02, 01:20", "2022-03-12, 20:20 - 2022-03-12, 23:50"}));
    }
}