package edu.project3.collectors;

import edu.project3.filters.DateFilter;
import edu.project3.models.Log;
import edu.project3.models.Table;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MostPopularIPAddresses {
    @SuppressWarnings("MagicNumber")
    public Table collectInformationAboutMostPopularIPAddresses(String from, String to, List<Log> logs) {
        DateFilter dateFilter = new DateFilter(from, to);
        List<String> allLines = logs.stream().filter(dateFilter::isLogFits)
            .collect(Collectors.groupingBy(Log::remoteAddress, Collectors.counting()))
            .entrySet().stream()
            .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
            .limit(50)
            .map(entry -> entry.getKey() + "!!!" + entry.getValue())
            .collect(Collectors.toList());
        return new Table("IP addresses", List.of("IP", "Amount"), allLines);
    }
}
