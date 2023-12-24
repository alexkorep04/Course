package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task6Test {
    @Test
    @DisplayName("Test that string is subsequence of other string")
    public void testSubsequence() {
        boolean response = Task6.isSubsequence("achfdbaabgabcaabg", "abc");

        assertThat(response).isTrue();
    }

    @Test
    @DisplayName("Test that string is not subsequence of other string")
    public void testNotSubsequence() {
        boolean response = Task6.isSubsequence("achfdbaabgabcaabg", "abcgh");

        assertThat(response).isFalse();
    }
}
