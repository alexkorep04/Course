package edu.project3;

import edu.project3.collectors.CodeResponses;
import edu.project3.models.Log;
import edu.project3.models.Request;
import edu.project3.models.Response;
import edu.project3.models.Table;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import static org.assertj.core.api.Assertions.assertThat;

public class CodeResponsesTest {
    CodeResponses codeResponses;
    Log log1;
    Log log2;
    Log log3;
    Log log4;
    Log log5;
    Log log6;
    Log log7;
    Log log8;

    @BeforeEach
    public void createObject() {
        codeResponses = new CodeResponses();
        log1 = new Log("20.20.1.120", "-", OffsetDateTime.parse("21/Sep/2019:09:45:21 +0001", FORMATTER)
            , new Request("GET", "/downloads/product", "HTTP/1.3", "Debian APT-HTTP")
            , new Response(200, 1), "-");
        log2 = new Log("20.20.1.120", "-", OffsetDateTime.parse("21/Sep/2019:09:45:21 +0001", FORMATTER)
            , new Request("GET", "/downloads/product", "HTTP/1.3", "Debian APT-HTTP")
            , new Response(201, 1), "-");
        log3 = new Log("20.20.1.120", "-", OffsetDateTime.parse("21/Sep/2019:09:45:21 +0001", FORMATTER)
            , new Request("GET", "/downloads/product", "HTTP/1.3", "Debian APT-HTTP")
            , new Response(201, 1), "-");
        log4 = new Log("20.20.1.120", "-", OffsetDateTime.parse("21/Sep/2019:09:45:21 +0001", FORMATTER)
            , new Request("GET", "/downloads/product", "HTTP/1.3", "Debian APT-HTTP")
            , new Response(400, 1), "-");
        log5 = new Log("20.20.1.120", "-", OffsetDateTime.parse("21/Sep/2009:09:45:21 +0001", FORMATTER)
            , new Request("GET", "/downloads/product", "HTTP/1.3", "Debian APT-HTTP")
            , new Response(200, 1), "-");
        log6 = new Log("20.20.1.120", "-", OffsetDateTime.parse("21/Sep/2009:09:45:21 +0001", FORMATTER)
            , new Request("GET", "/downloads/product", "HTTP/1.3", "Debian APT-HTTP")
            , new Response(201, 1), "-");
        log7 = new Log("20.20.1.120", "-", OffsetDateTime.parse("21/Sep/2019:09:45:21 +0001", FORMATTER)
            , new Request("GET", "/downloads/product", "HTTP/1.3", "Debian APT-HTTP")
            , new Response(201, 1), "-");
        log8 = new Log("20.20.1.120", "-", OffsetDateTime.parse("21/Sep/2019:09:45:21 +0001", FORMATTER)
            , new Request("GET", "/downloads/product", "HTTP/1.3", "Debian APT-HTTP")
            , new Response(201, 1), "-");
    }

    private static final DateTimeFormatter FORMATTER =
        DateTimeFormatter.ofPattern("dd/MMM/yyyy:HH:mm:ss Z", Locale.ENGLISH);

    @Test
    @DisplayName("Test returning of code responses where all logs fits dates")
    public void testReturningOfCodeResponses() {
        List<Log> logs = List.of(log1, log2, log3, log4);

        Table expected = new Table("Response codes",
            List.of("Code", "Name", "Amount"),
            List.of("201!!!Created!!!2", "200!!!OK!!!1", "400!!!Bad Request!!!1")
        );

        Table response = codeResponses.collectResponseCodes(
            "2010-01-01",
            "2020-01-01",
            logs
        );

        assertThat(expected).isEqualTo(response);
    }

    @Test
    @DisplayName("Test returning of code responses where some logs not fits dates")
    public void testReturningOfCodeResponsesWhereSomeLogsNotFitDates() {
        List<Log> logs = List.of(log5, log6, log7, log8);

        Table expected = new Table("Response codes", List.of("Code", "Name", "Amount"), List.of("201!!!Created!!!2"));

        Table response = codeResponses.collectResponseCodes(
            "2010-01-01",
            "2020-01-01",
            logs
        );

        assertThat(expected).isEqualTo(response);
    }
}
