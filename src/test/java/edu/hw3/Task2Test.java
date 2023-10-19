package edu.hw3;

import edu.hw3.task1.AtbashCode;
import edu.hw3.task2.BracketCluster;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {
    @Test
    @DisplayName("Test splitting brackets in difficult string")
    public void testDifficultString()
    {
        List<String> expected = List.of("((()))", "(())", "()", "()", "(()())");

        List<String> response = BracketCluster.clusterizeString("((()))(())()()(()())");

        assertThat(expected).isEqualTo(response);
    }
    @Test
    @DisplayName("Test splitting brackets in simple string")
    public void testSimpleString()
    {
        List<String> expected = List.of("()");

        List<String> response = BracketCluster.clusterizeString("()");

        assertThat(expected).isEqualTo(response);
    }
    @Test
    @DisplayName("Test null string")
    public void testNullString()
    {
        List<String> expected = List.of();

        List<String> response = BracketCluster.clusterizeString("");

        assertThat(expected).isEqualTo(response);
    }
}
