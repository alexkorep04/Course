package edu.project4;

import edu.project4.functions.HyperbolicTransformation;
import edu.project4.functions.Transformation;
import edu.project4.entities.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class HyperbolicTransformationTest {
    @Test
    @DisplayName("Test hyperbolic transformation")
    public void testHyperbolic() {
        Transformation hyberbolicTransformation = new HyperbolicTransformation();

        Point expected = new Point(0.7999999999999999, 0.5000000000000001);

        Point response = hyberbolicTransformation.apply(new Point(0.5, 1));

        assertThat(expected).isEqualTo(response);
    }
}
