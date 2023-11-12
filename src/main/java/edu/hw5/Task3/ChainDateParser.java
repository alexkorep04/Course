package edu.hw5.Task3;

import java.time.LocalDate;
import java.util.Optional;

public class ChainDateParser implements DateParser {
    private final DateParser[] parsers;

    public ChainDateParser(DateParser... parsers) {
        this.parsers = parsers;
    }

    @Override
    public Optional<LocalDate> parse(String input) {
        for (DateParser parser : parsers) {
            Optional<LocalDate> result = parser.parse(input);
            if (result.isPresent()) {
                return result;
            }
        }
        return Optional.empty();
    }
}
