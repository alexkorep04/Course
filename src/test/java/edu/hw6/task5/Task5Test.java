package edu.hw6.task5;

import edu.hw6.HackerNews;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task5Test {
    HackerNews hackerNews;

    @BeforeEach
    public void createObject() {
        hackerNews = new HackerNews();
    }

    @Test
    @DisplayName("Test returning of name")
    public void testReturningOfName() {
        String expected = "JDK 21 Release Notes";

        String response = hackerNews.news(37570037l);

        assertThat(expected).isEqualTo(response);
    }
}
