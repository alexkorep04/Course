package edu.project3;

import edu.project3.models.Log;
import edu.project3.models.Request;
import edu.project3.models.Response;
import edu.project3.parsers.LogParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import static org.assertj.core.api.Assertions.assertThat;

public class LogParserTest {

    private static final DateTimeFormatter FORMATTER =
        DateTimeFormatter.ofPattern("dd/MMM/yyyy:HH:mm:ss Z", Locale.ENGLISH);

    @Test
    @DisplayName("Test parsing string to log")
    public void testParseToLog() {
        Log expected = new Log("20.20.1.120", "-", OffsetDateTime.parse("21/Sep/2019:09:45:21 +0001", FORMATTER)
            , new Request("GET", "/downloads/product", "HTTP/1.3", "Debian APT-HTTP")
            , new Response(200, 1), "-");

        Log response = LogParser.parseLog(
            "20.20.1.120 - - [21/Sep/2019:09:45:21 +0001] \"GET /downloads/product HTTP/1.3\" 200 1 \"-\" \"Debian APT-HTTP\"");
        assertThat(expected).isEqualTo(response);
    }
}
