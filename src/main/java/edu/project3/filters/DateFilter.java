package edu.project3.filters;

import edu.project3.models.Log;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class DateFilter {
    private final OffsetDateTime from;
    private final OffsetDateTime to;
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public DateFilter(String from,String to) {
        if(from == null) {
            this.from = OffsetDateTime.MIN;
        } else {
            this.from = LocalDate.parse(from, dateTimeFormatter).atStartOfDay().atOffset(ZoneOffset.UTC);
        }
        if(to == null) {
            this.to = OffsetDateTime.MAX;
        } else {
            this.to = LocalDate.parse(to, dateTimeFormatter).atStartOfDay().atOffset(ZoneOffset.UTC);
        }
    }
    public boolean isLogFits(Log log) {
        return log.time().isAfter(from) && log.time().isBefore(to);
    }
}
