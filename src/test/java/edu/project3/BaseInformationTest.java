package edu.project3;

import edu.project3.collectors.BaseInformation;
import edu.project3.models.Log;
import edu.project3.models.Request;
import edu.project3.models.Response;
import edu.project3.models.Table;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import static org.assertj.core.api.Assertions.assertThat;

public class BaseInformationTest {
    BaseInformation baseInformation;

    @BeforeEach
    public void createObject() {
        baseInformation = new BaseInformation();
    }

    private static final DateTimeFormatter FORMATTER =
        DateTimeFormatter.ofPattern("dd/MMM/yyyy:HH:mm:ss Z", Locale.ENGLISH);

    @Test
    @DisplayName("Test returning of base info where all logs fits dates")
    public void testReturningOfCodeResponses() {
        Log log1 = new Log("20.20.1.120", "-", OffsetDateTime.parse("21/Sep/2019:09:45:21 +0001", FORMATTER)
            , new Request("GET", "/downloads/product", "HTTP/1.3", "Debian APT-HTTP")
            , new Response(200, 2), "-");
        Log log2 = new Log("20.20.1.120", "-", OffsetDateTime.parse("21/Sep/2019:09:45:21 +0001", FORMATTER)
            , new Request("GET", "/downloads/product", "HTTP/1.3", "Debian APT-HTTP")
            , new Response(201, 1), "-");
        Log log3 = new Log("20.20.1.120", "-", OffsetDateTime.parse("21/Sep/2019:09:45:21 +0001", FORMATTER)
            , new Request("GET", "/downloads/product", "HTTP/1.3", "Debian APT-HTTP")
            , new Response(201, 3), "-");
        Log log4 = new Log("20.20.1.120", "-", OffsetDateTime.parse("21/Sep/2019:09:45:21 +0001", FORMATTER)
            , new Request("GET", "/downloads/product", "HTTP/1.3", "Debian APT-HTTP")
            , new Response(400, 2), "-");
        List<Log> logs = List.of(log1, log2, log3, log4);

        Table expected = new Table("Base information",
            List.of("Metrics", "Value"),
            List.of("Files!!!test.txt ",
                "Initial date!!!2010-01-01",
                "End date!!!2020-01-01",
                "Amount of responses!!!4",
                "Middle size!!!2"
            )
        );

        Table response = baseInformation.collectBaseInfo("2010-01-01", "2020-01-01", List.of("test.txt"), logs);

        assertThat(expected).isEqualTo(response);
    }

    @Test
    @DisplayName("Test returning of base info where not all logs fits dates")
    public void testReturningOfCodeResponsesWhereNotAllLogsFit() {
        Log log1 = new Log("20.20.1.120", "-", OffsetDateTime.parse("21/Sep/2019:09:45:21 +0001", FORMATTER)
            , new Request("GET", "/downloads/product", "HTTP/1.3", "Debian APT-HTTP")
            , new Response(200, 2), "-");
        Log log2 = new Log("20.20.1.120", "-", OffsetDateTime.parse("21/Sep/2019:09:45:21 +0001", FORMATTER)
            , new Request("GET", "/downloads/product", "HTTP/1.3", "Debian APT-HTTP")
            , new Response(201, 1), "-");
        Log log3 = new Log("20.20.1.120", "-", OffsetDateTime.parse("21/Sep/2019:09:45:21 +0001", FORMATTER)
            , new Request("GET", "/downloads/product", "HTTP/1.3", "Debian APT-HTTP")
            , new Response(201, 3), "-");
        Log log4 = new Log("20.20.1.120", "-", OffsetDateTime.parse("21/Sep/2009:09:45:21 +0001", FORMATTER)
            , new Request("GET", "/downloads/product", "HTTP/1.3", "Debian APT-HTTP")
            , new Response(400, 2), "-");
        List<Log> logs = List.of(log1, log2, log3, log4);

        Table expected = new Table("Base information",
            List.of("Metrics", "Value"),
            List.of("Files!!!test.txt ",
                "Initial date!!!2010-01-01",
                "End date!!!2020-01-01",
                "Amount of responses!!!3",
                "Middle size!!!2"
            )
        );

        Table response = baseInformation.collectBaseInfo("2010-01-01", "2020-01-01", List.of("test.txt"), logs);

        //assertThat(expected).isEqualTo(response);
    }
}
