package edu.hw5.Task3;

import java.time.LocalDate;
import java.util.Optional;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternDateParser implements DateParser {
    private final Pattern pattern;
    private final Function<Matcher, LocalDate> function;

    public PatternDateParser(Pattern pattern, Function<Matcher, LocalDate> function) {
        this.pattern = pattern;
        this.function = function;
    }

    @Override
    public Optional<LocalDate> parse(String input) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            return Optional.of(function.apply(matcher));
        }
        return Optional.empty();
    }
}
