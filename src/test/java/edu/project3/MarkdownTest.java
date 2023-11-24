package edu.project3;

import edu.project3.models.Log;
import edu.project3.models.Request;
import edu.project3.models.Response;
import edu.project3.models.Table;
import edu.project3.printers.Markdown;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.OffsetDateTime;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class MarkdownTest {
    Markdown markdown;

    @BeforeEach
    public void createObject() {
        markdown = new Markdown();
    }

    @Test
    @DisplayName("Testing printing markdown")
    public void testPrintingMarkdown() {
        Table table = new Table("Dates",
            List.of("Date", "Amount"),
            List.of("2013-09-21!!!2", "2017-09-21!!!1", "2019-09-21!!!1")
        );

        String expected =
            "### Dates\n" +
                "|Date       |Amount |\n" +
                "|:---------:|:-----:|\n" +
                "|2013-09-21 |2      |\n" +
                "|2017-09-21 |1      |\n" +
                "|2019-09-21 |1      |\n"
        ;

        String response = markdown.printTable(table).toString();

        assertThat(expected).isEqualTo(response);
    }
}
