package edu.project3;

import edu.project3.sources.URLSource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class URLSourceTest {
    URLSource urlSource;
    @BeforeEach
    public void createObject() {
        urlSource = new URLSource();
    }
    @Test
    @DisplayName("Testing getting logs by URL")
    public void testOfGettingLogsByURL() {
        int expected = 51462;
        List<String> strings = urlSource.getLogsByURL("https://raw.githubusercontent.com/elastic/examples/master/Common%20Data%20Formats/nginx_logs/nginx_logs");

        int response = strings.size();

        assertThat(expected).isEqualTo(response);
        assertThat("93.180.71.3 - - [17/May/2015:08:05:32 +0000] \"GET /downloads/product_1 HTTP/1.1\" 304 0 \"-\" \"Debian APT-HTTP/1.3 (0.8.16~exp12ubuntu10.21)\"")
            .isEqualTo(strings.get(0));
        assertThat("79.136.114.202 - - [04/Jun/2015:07:06:35 +0000] \"GET /downloads/product_1 HTTP/1.1\" 404 334 \"-\" \"Debian APT-HTTP/1.3 (0.8.16~exp12ubuntu10.22)\"")
            .isEqualTo(strings.get(strings.size()-1));
        assertThat("80.91.33.133 - - [17/May/2015:08:05:24 +0000] \"GET /downloads/product_1 HTTP/1.1\" 304 0 \"-\" \"Debian APT-HTTP/1.3 (0.8.16~exp12ubuntu10.17)\"")
            .isEqualTo(strings.get(2));
    }
}
