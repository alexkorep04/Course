package edu.project4;

import edu.project4.Functions.PolarTransformation;
import edu.project4.Functions.SinusTransformation;
import edu.project4.Functions.Transformation;
import edu.project4.entities.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class SinusTransformationTest {
    @Test
    @DisplayName("Test sinus transformation")
    public void testSinus() {
        Transformation sinusTransformation = new SinusTransformation();

        Point expected = new Point(0.479425538604203, 0.8414709848078965);

        Point response = sinusTransformation.apply(new Point(0.5, 1));

        assertThat(expected).isEqualTo(response);
    }
}
