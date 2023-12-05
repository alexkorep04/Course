package edu.project4;

import edu.project4.Functions.SinusTransformation;
import edu.project4.Functions.SphereTransformation;
import edu.project4.Functions.Transformation;
import edu.project4.entities.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class SphereTransformationTest {
    @Test
    @DisplayName("Test sphere transformation")
    public void testSphere() {
        Transformation sphereTransformation = new SphereTransformation();

        Point expected = new Point(0.4, 0.8);

        Point response = sphereTransformation.apply(new Point(0.5, 1));

        assertThat(expected).isEqualTo(response);
    }
}
