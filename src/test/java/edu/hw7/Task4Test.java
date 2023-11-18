package edu.hw7;

import edu.hw7.Task4.PiCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task4Test {
    @Test
    @DisplayName("Test calculating PI value on 1000000 iterations")
    public void testCalculatingPi() {
        PiCalculator piCalculator = new PiCalculator(1000000);
        double EPS = 1e-2;
        double ourPi = piCalculator.calculatePiValue();
        double PI = Math.PI;

        assertThat(Math.abs(ourPi - PI)).isLessThan(EPS);
    }
}
