package edu.project4;

import edu.project4.functions.PowerTransformation;
import edu.project4.functions.Transformation;
import edu.project4.entities.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class PowerTransformationTest {
    @Test
    @DisplayName("Test power transformation")
    public void testPower() {
        Transformation powerTransformation = new PowerTransformation();

        Point expected = new Point(0.4941450772225398, 0.9882901544450794);

        Point response = powerTransformation.apply(new Point(0.5, 1));

        assertThat(expected).isEqualTo(response);
    }
}
