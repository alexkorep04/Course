package edu.hw5.Task3;

import java.time.LocalDate;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task3 {
    private Task3() {
    }

    private final static Pattern PATTERN1 = Pattern.compile("^\\d{4}-\\d{2}-\\d{2}$");
    private final static Pattern PATTERN2 = Pattern.compile("^\\d{4}-\\d{2}-\\d$");
    private final static Pattern PATTERN3 = Pattern.compile("^\\d{1,2}/\\d{1,2}/\\d{4}$");
    private final static Pattern PATTERN4 = Pattern.compile("^\\d{1,2}/\\d{1,2}/\\d{2}$");
    private final static Pattern PATTERN5 = Pattern.compile("^tomorrow$");
    private final static Pattern PATTERN6 = Pattern.compile("^today$");
    private final static Pattern PATTERN7 = Pattern.compile("^yesterday$");
    private final static Pattern PATTERN8 = Pattern.compile("^1 day ago$");
    private final static Pattern PATTERN9 = Pattern.compile("^\\d{1,6} days ago$");

    @SuppressWarnings("MagicNumber")

    private static DateParser createDateParserChain() {
        return new ChainDateParser(
            new PatternDateParser(PATTERN1, (Matcher matcher) -> {
                String[] parts = matcher.group().split("-");
                return LocalDate.of(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
            }),
            new PatternDateParser(PATTERN2, (Matcher matcher) -> {
                String[] parts = matcher.group().split("-");
                return LocalDate.of(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
            }),
            new PatternDateParser(PATTERN3, (Matcher matcher) -> {
                String[] parts = matcher.group().split("/");
                return LocalDate.of(Integer.parseInt(parts[2]), Integer.parseInt(parts[1]), Integer.parseInt(parts[0]));
            }),
            new PatternDateParser(PATTERN4, (Matcher matcher) -> {
                String[] parts = matcher.group().split("/");
                LocalDate now = LocalDate.now();
                int year = now.getYear() - now.getYear() % 100 + Integer.parseInt(parts[2]);
                return LocalDate.of(year, Integer.parseInt(parts[1]), Integer.parseInt(parts[0]));
            }),
            new PatternDateParser(PATTERN5, (Matcher matcher) -> LocalDate.now().plusDays(1)),
            new PatternDateParser(PATTERN6, (Matcher matcher) -> LocalDate.now()),
            new PatternDateParser(PATTERN7, (Matcher matcher) -> LocalDate.now().minusDays(1)),
            new PatternDateParser(PATTERN8, (Matcher matcher) -> LocalDate.now().minusDays(1)),
            new PatternDateParser(PATTERN9, (Matcher matcher) -> {
                String[] parts = matcher.group().split(" ");
                return LocalDate.now().minusDays(Integer.parseInt(parts[0]));
            })
        );
    }

    public static Optional<LocalDate> parseDate(String date) {
        DateParser dateParser = createDateParserChain();
        return dateParser.parse(date);
    }
}
