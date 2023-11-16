package edu.project3.parsers;

import edu.project3.models.Log;
import edu.project3.models.Request;
import edu.project3.models.Response;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogParser {
    private LogParser() {
    }

    private static final String REGEX_FOR_LOG
        = ("(.*) - (.*) \\[(.*)\\] \"(GET|POST|PUT|HEAD|DELETE|PATCH) (.*) (.*)\" (\\d{3}) (\\d+) \"(.*)\" \"(.*)\"");
    private static final DateTimeFormatter DATE_TIME_FORMATTER
        = DateTimeFormatter.ofPattern("dd/MMM/yyyy:HH:mm:ss Z", Locale.ENGLISH);

    @SuppressWarnings("MagicNumber")
    public static Log parseLog(String log) {
        Pattern pattern = Pattern.compile(REGEX_FOR_LOG);
        Matcher matcher = pattern.matcher(log);
        if (!matcher.matches()) {
            throw new IllegalStateException("Log is not correct!");
        }
        return new Log(matcher.group(1), matcher.group(2), OffsetDateTime.parse(matcher.group(3), DATE_TIME_FORMATTER),
            new Request(matcher.group(4), matcher.group(5), matcher.group(6), matcher.group(10)),
            new Response(Integer.parseInt(matcher.group(7)), Integer.parseInt(matcher.group(8))), matcher.group(9));
    }
}
