package edu.project3.parsers;

import edu.project3.models.Log;
import edu.project3.models.Request;
import edu.project3.models.Response;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogParser {
    private static final String REGEX_FOR_LOG = ("^(\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}) - (.*) \\[(\\d{2}/[A-Z][a-z]{2}/\\d{4}:\\d{2}:\\d{2}:\\d{2} [+|-]\\d{4})] \"([A-Z]+\\s[^\\\\s]+\\sHTTP/\\d\\.\\d)\" (\\d{3}) (\\d+) \"([^\"]*)\" \"([^\"]*)\"$");
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MMM/yyyy:HH:mm:ss Z");
    public Log parseLog(String log) {
        Pattern pattern = Pattern.compile(REGEX_FOR_LOG);
        Matcher matcher = pattern.matcher(log);
        if(!matcher.matches()) {
            throw new IllegalStateException("Log is not correct!");
        }
        return new Log(matcher.group(1), matcher.group(2), OffsetDateTime.parse(matcher.group(3), dateTimeFormatter), new Request(
            matcher.group(4), matcher.group(5), matcher.group(6), matcher.group(10)), new Response(Integer.parseInt(matcher.group(7)), Integer.parseInt(matcher.group(8))), matcher.group(9));
    }
}
