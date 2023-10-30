package edu.hw5;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

public class Task2 {
    public static List<LocalDate> getAllFridaysThe13ByYear(int year) {
        List<LocalDate> fridays = new ArrayList<>();
        for(int month = 1; month <= 12; month++) {
            LocalDate localDate = LocalDate.of(year,month, 13);
            if(localDate.getDayOfWeek() == DayOfWeek.FRIDAY) {
                fridays.add(localDate);
            }
        }
        return fridays;
    }
    public static LocalDate findNextFridayThe13th(LocalDate date) {
        LocalDate nextFridayThe13th = date;
        do {
            nextFridayThe13th = nextFridayThe13th.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        } while (nextFridayThe13th.getDayOfMonth() != 13);

        return nextFridayThe13th;
    }
}
