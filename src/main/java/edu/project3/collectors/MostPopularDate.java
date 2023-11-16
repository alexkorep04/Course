package edu.project3.collectors;

import edu.project3.filters.DateFilter;
import edu.project3.models.Log;
import edu.project3.models.Table;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MostPopularDate {
    @SuppressWarnings("MagicNumber")
    public Table collectInformationAboutMostPopularDate(String from, String to, List<Log> logs) {
        List<Log> requiredLogs = new ArrayList<>();
        DateFilter dateFilter = new DateFilter(from, to);
        for (Log log: logs) {
            if (dateFilter.isLogFits(log)) {
                requiredLogs.add(log);
            }
        }
        List<String> allLines = requiredLogs.stream()
            .collect(Collectors.groupingBy(log -> log.time().toLocalDate(), Collectors.counting()))
            .entrySet().stream()
            .sorted(Map.Entry.<LocalDate, Long>comparingByValue().reversed())
            .limit(50)
            .map(entry -> entry.getKey() + "!!!" + entry.getValue())
            .collect(Collectors.toList());
        return new Table("Dates", List.of("Date", "Amount"), allLines);
    }
}
