package edu.hw11;

import edu.hw11.task1.Hello;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class Task1Test {
    Hello hello = new Hello();
    @Test
    @DisplayName("Test toString representation")
    public void testToString() throws Exception {
        String expected = "Hello, ByteBuddy!";

        String response = hello.sayHello();

        assertThat(expected).isEqualTo(response);
    }
}
