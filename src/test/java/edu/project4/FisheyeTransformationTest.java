package edu.project4;

import edu.project4.functions.FisheyeTransformation;
import edu.project4.functions.Transformation;
import edu.project4.entities.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class FisheyeTransformationTest {
    @Test
    @DisplayName("Test fisheye transformation")
    public void testFisheye() {
        Transformation fisheyeTransformation = new FisheyeTransformation();

        Point expected = new Point(0.9442719099991588, 0.4721359549995794);

        Point response = fisheyeTransformation.apply(new Point(0.5, 1));

        assertThat(expected).isEqualTo(response);
    }
}
