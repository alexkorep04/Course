package edu.project3.collectors;

import edu.project3.filters.DateFilter;
import edu.project3.models.Codes;
import edu.project3.models.Log;
import edu.project3.models.Response;
import edu.project3.models.Table;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CodeResponses {
    public Table collectResponseCodes(String from, String to, List<Log> logs) {
        DateFilter dateFilter = new DateFilter(from, to);
        List<String> allLines = logs.stream().filter(dateFilter::isLogFits).map(Log::response)
            .collect(Collectors.collectingAndThen(
            Collectors.groupingBy(Response::code, Collectors.counting()),
            map -> map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .map(entry -> Codes.getByValue(entry.getKey()) + "!!!"
                    + entry.getValue())
                .collect(Collectors.toList()).reversed()
        ));
        return new Table("Response codes", List.of("Code", "Name", "Amount"), allLines);
    }
}
