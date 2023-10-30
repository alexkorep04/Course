package edu.hw5;

import java.time.LocalDate;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task3 {
    public static Optional<LocalDate> parseDate(String string) {
        Pattern pattern1 = Pattern.compile("^\\d{4}-\\d{2}-\\d{2}$");
        Pattern pattern2 = Pattern.compile("^\\d{4}-\\d{2}-\\d$");
        Pattern pattern3 = Pattern.compile("^\\d{1,2}/\\d{1,2}/\\d{4}$");
        Pattern pattern4 = Pattern.compile("^\\d{1,2}/\\d{1,2}/\\d{2}$");
        Pattern pattern5 = Pattern.compile("^tomorrow$");
        Pattern pattern6 = Pattern.compile("^today$");
        Pattern pattern7 = Pattern.compile("^yesterday$");
        Pattern pattern8 = Pattern.compile("^1 day ago$");
        Pattern pattern9 = Pattern.compile("^\\d{1,6} days ago$");
        Matcher matcher1 = pattern1.matcher(string);
        Matcher matcher2 = pattern2.matcher(string);
        Matcher matcher3 = pattern3.matcher(string);
        Matcher matcher4 = pattern4.matcher(string);
        Matcher matcher5 = pattern5.matcher(string);
        Matcher matcher6 = pattern6.matcher(string);
        Matcher matcher7 = pattern7.matcher(string);
        Matcher matcher8 = pattern8.matcher(string);
        Matcher matcher9 = pattern9.matcher(string);
        LocalDate date = null;
        LocalDate now = LocalDate.now();
        if(matcher1.find() || matcher2.find()) {
            String[] parts = string.split("-");
            int year = Integer.parseInt(parts[0]);
            int month = Integer.parseInt(parts[1]);
            int day = Integer.parseInt(parts[2]);
            date = LocalDate.of(year, month, day);
        } else if(matcher3.find()) {
            String[] parts = string.split("/");
            int year = Integer.parseInt(parts[2]);
            int month = Integer.parseInt(parts[1]);
            int day = Integer.parseInt(parts[0]);
            date = LocalDate.of(year, month, day);
        }
        else if(matcher4.find()) {
            String[] parts = string.split("/");
            int year = now.getYear() - now.getYear()%100 + Integer.parseInt(parts[2]);
            int month = Integer.parseInt(parts[1]);
            int day = Integer.parseInt(parts[0]);
            date = LocalDate.of(year, month, day);
        }
        else if(matcher5.find() ) {
            date = LocalDate.of(now.getYear(), now.getMonth(), now.getDayOfMonth());
            date = date.plusDays(1);
        }
        else if(matcher6.find()) {
            date = LocalDate.of(now.getYear(), now.getMonth(), now.getDayOfMonth());
        }
        else if(matcher7.find() || matcher8.find()) {
            date = LocalDate.of(now.getYear(), now.getMonth(), now.getDayOfMonth());
            date = date.minusDays(1);
        }
        else if(matcher9.find()) {
            String[] parts = string.split(" ");
            date = LocalDate.of(now.getYear(), now.getMonth(), now.getDayOfMonth());
            date = date.minusDays(Integer.parseInt(parts[0]));
        }
        if(date == null) {
            return Optional.empty();
        }
        return Optional.of(date);
    }
}
