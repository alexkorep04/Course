package edu.project4;

import edu.project4.functions.DiamondTransformation;
import edu.project4.functions.Transformation;
import edu.project4.entities.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class DiamondTransformationTest {
    @Test
    @DisplayName("Test diamond transformation")
    public void testDiamond() {
        Transformation diamondTransformation = new DiamondTransformation();

        Point expected = new Point(0.39126825761507067, 0.4021533136077791);

        Point response = diamondTransformation.apply(new Point(0.5, 1));

        assertThat(expected).isEqualTo(response);
    }
}
