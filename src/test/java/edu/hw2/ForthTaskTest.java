package edu.hw2;

import edu.hw2.forth.CallingInfoTools;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
public class ForthTaskTest {
    @Test
    @DisplayName("Test getting method name")
    void testCallInfoMethod() {
        String expected = "testCallInfoMethod";

        CallingInfoTools.CallingInfo callingInfo = CallingInfoTools.callingInfo();

        assertThat(expected).isEqualTo(callingInfo.methodName());
    }
    @Test
    @DisplayName("Test getting class name")
    void testCallInfoClass() {
        String expected = "edu.hw2.ForthTaskTest";

        CallingInfoTools.CallingInfo callingInfo = CallingInfoTools.callingInfo();

        assertThat(expected).isEqualTo(callingInfo.className());
    }
}
