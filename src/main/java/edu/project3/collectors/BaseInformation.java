package edu.project3.collectors;

import edu.project3.filters.DateFilter;
import edu.project3.models.Log;
import edu.project3.models.Response;
import edu.project3.models.Table;
import java.util.ArrayList;
import java.util.List;

public class BaseInformation {
    @SuppressWarnings("ParameterAssignment")
    public Table collectBaseInfo(String from, String to, List<String> sources, List<Log> logs) {
        List<Log> requiredLogs = new ArrayList<>();
        DateFilter dateFilter = new DateFilter(from, to);
        for (Log log: logs) {
            if (dateFilter.isLogFits(log)) {
                requiredLogs.add(log);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String file: sources) {
            stringBuilder.append(file);
            stringBuilder.append(" ");
        }
        long sumSize = requiredLogs.stream().map(Log::response).mapToLong(Response::bytesSent).sum();
        long midSize;
        if (requiredLogs.size() == 0) {
            midSize = 0;
        } else {
            midSize = sumSize / requiredLogs.size();
        }
        int amountOfResponses = requiredLogs.size();
        if (from == null) {
            from = "-";
        }
        if (to == null) {
            to = "-";
        }
        String file = "Files!!!" + stringBuilder.toString();
        String dateFrom = "Initial date!!!" + from;
        String endDate = "End date!!!" + to;
        String amount = "Amount of responses!!!" + amountOfResponses;
        String mid = "Middle size!!!" + midSize;
        return new Table("Base information", List.of("Metrics", "Value"),
            List.of(file, dateFrom, endDate, amount, mid));
    }
}
