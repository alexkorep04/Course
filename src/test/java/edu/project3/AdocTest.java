package edu.project3;

import edu.project3.models.Table;
import edu.project3.printers.Adoc;
import edu.project3.printers.Markdown;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class AdocTest {
    Adoc adoc;

    @BeforeEach
    public void createObject() {
        adoc = new Adoc();
    }

    @Test
    @DisplayName("Testing printing adoc")
    public void testPrintingMarkdown() {
        Table
            table = new Table("Dates",
            List.of("Date", "Amount"),
            List.of("2013-09-21!!!2", "2017-09-21!!!1", "2019-09-21!!!1")
        );

        String expected = new String(
            "=== Dates\n" +
                "|==================\n" +
                "|Date      |Amount\n" +
                "\n" +
                "|2013-09-21|2     |\n" +
                "|2017-09-21|1     |\n" +
                "|2019-09-21|1     |\n" +
                "==================="
        );

        String response = adoc.printTable(table).toString();

        assertThat(expected).isEqualTo(response);
    }
}
