package edu.hw7;

import edu.hw7.Task1.IncrementClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.concurrent.atomic.AtomicInteger;
import static org.assertj.core.api.Assertions.assertThat;

public class Task1Test {
    IncrementClass incrementClass;

    @BeforeEach
    public void createObjects() {
        incrementClass = new IncrementClass();
    }

    @Test
    @DisplayName("Test atomicity of increment")
    public void testAtomicity() {
        var expected = 200000;

        var response = incrementClass.incrementCounter();

        assertThat(response).isInstanceOf(AtomicInteger.class);
        assertThat(expected).isEqualTo(Integer.parseInt(String.valueOf(response)));
    }
}
