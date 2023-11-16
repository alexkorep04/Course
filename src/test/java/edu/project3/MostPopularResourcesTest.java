package edu.project3;

import edu.project3.collectors.MostPopularResources;
import edu.project3.models.Log;
import edu.project3.models.Request;
import edu.project3.models.Response;
import edu.project3.models.Table;
import edu.project3.printers.Adoc;
import edu.project3.printers.Markdown;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import static org.assertj.core.api.Assertions.assertThat;

public class MostPopularResourcesTest {
    MostPopularResources mostPopularResources;
    @BeforeEach
    public void createObject() {
        mostPopularResources = new MostPopularResources();
    }
    private static final DateTimeFormatter FORMATTER =
        DateTimeFormatter.ofPattern("dd/MMM/yyyy:HH:mm:ss Z", Locale.ENGLISH);
    private static final DateTimeFormatter FORMATTER2 =
        DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
    @Test
    @DisplayName("Testing returning most popular resources")
    public void testResources() {
        Log log1 = new Log("20.20.1.120", "-", OffsetDateTime.parse("21/Sep/2019:09:45:21 +0001", FORMATTER)
            , new Request("GET", "/downloads/product1", "HTTP/1.3", "Debian APT-HTTP")
            , new Response(200, 1), "-");
        Log log2 = new Log("20.20.1.120", "-", OffsetDateTime.parse("21/Sep/2019:09:45:21 +0001", FORMATTER)
            , new Request("GET", "/downloads/product3", "HTTP/1.3", "Debian APT-HTTP")
            , new Response(201, 1), "-");
        Log log3 = new Log("20.20.1.120", "-", OffsetDateTime.parse("21/Sep/2019:09:45:21 +0001", FORMATTER)
            , new Request("GET", "/downloads/product2", "HTTP/1.3", "Debian APT-HTTP")
            , new Response(201, 1), "-");
        Log log4 = new Log("20.20.1.120", "-", OffsetDateTime.parse("21/Sep/2019:09:45:21 +0001", FORMATTER)
            , new Request("GET", "/downloads/product2", "HTTP/1.3", "Debian APT-HTTP")
            , new Response(400, 1), "-");
        List<Log> logs = List.of(log1, log2, log3, log4);

        Table expected = new Table("Resources", List.of("Resource", "Amount"), List.of("/downloads/product2:2", "/downloads/product1:1", "/downloads/product3:1"));

        Table response = mostPopularResources.collectInformationAboutMostPopularResources(
            "2010-01-01",
            "2020-01-01",
            logs);

        assertThat(expected).isEqualTo(response);
    }
    @Test
    @DisplayName("Testing returning most popular resources where not all logs fits")
    public void testResourcesWhereNotAllDatesFits() {
        Log log1 = new Log("20.20.1.120", "-", OffsetDateTime.parse("21/Sep/2019:09:45:21 +0001", FORMATTER)
            , new Request("GET", "/downloads/product1", "HTTP/1.3", "Debian APT-HTTP")
            , new Response(200, 1), "-");
        Log log2 = new Log("20.20.1.120", "-", OffsetDateTime.parse("21/Sep/2019:09:45:21 +0001", FORMATTER)
            , new Request("GET", "/downloads/product3", "HTTP/1.3", "Debian APT-HTTP")
            , new Response(201, 1), "-");
        Log log3 = new Log("20.20.1.120", "-", OffsetDateTime.parse("21/Sep/2019:09:45:21 +0001", FORMATTER)
            , new Request("GET", "/downloads/product2", "HTTP/1.3", "Debian APT-HTTP")
            , new Response(201, 1), "-");
        Log log4 = new Log("20.20.1.120", "-", OffsetDateTime.parse("21/Sep/2009:09:45:21 +0001", FORMATTER)
            , new Request("GET", "/downloads/product2", "HTTP/1.3", "Debian APT-HTTP")
            , new Response(400, 1), "-");
        List<Log> logs = List.of(log1, log2, log3, log4);

        Table expected = new Table("Resources", List.of("Resource", "Amount"), List.of("/downloads/product1:1", "/downloads/product3:1", "/downloads/product2:1"));

        Table response = mostPopularResources.collectInformationAboutMostPopularResources(
            "2010-01-01",
            "2020-01-01",
            logs);

        assertThat(expected).isEqualTo(response);
    }
}
