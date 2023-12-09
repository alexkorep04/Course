package edu.hw11;

import edu.hw11.task2.SumChanger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task2Test {
    @Test
    @DisplayName("Test changing sum to multiply")
    public void testChangingSumToMultiply() throws Exception {
        int expected = 27;

        int response = SumChanger.change(3, 9);

        assertThat(expected).isEqualTo(response);
    }
}
