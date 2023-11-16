package edu.project3;

import edu.project3.sources.FileSource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.nio.file.Path;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class FileSourceTest {
    FileSource fileSource;
    @BeforeEach
    public void createObject() {
        fileSource = new FileSource();
    }
    @Test
    @DisplayName("Test getting logs from file")
    public void testGettingLogsFromFile() {
        int expected = 6;
        List<String> strings = fileSource.getLogsFromFile("log.txt");

        int response = strings.size();

        assertThat(expected).isEqualTo(response);
        assertThat("93.180.71.3 - - [17/May/2015:08:05:32 +0000] \"GET /downloads/product_1 HTTP/1.1\" 304 0 \"-\" \"Debian APT-HTTP/1.3 (0.8.16~exp12ubuntu10.21)\"")
            .isEqualTo(strings.get(0));
        assertThat("80.91.33.133 - - [17/May/2015:08:05:24 +0000] \"GET /downloads/product_1 HTTP/1.1\" 304 0 \"-\" \"Debian APT-HTTP/1.3 (0.8.16~exp12ubuntu10.17)\"")
            .isEqualTo(strings.get(2));
    }
}
