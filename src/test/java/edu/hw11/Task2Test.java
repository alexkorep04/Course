package edu.hw11;

import edu.hw11.task2.Arithmetic;
import edu.hw11.task2.SumChanger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task2Test {
    @BeforeEach
    public void create() throws Exception {
        SumChanger.change();
    }
    @Test
    @DisplayName("Test changing sum to multiply")
    public void testChangingSumToMultiply() throws Exception {
        int expected = 27;

        int response = Arithmetic.sum(3, 9);

        assertThat(expected).isEqualTo(response);
    }
}
