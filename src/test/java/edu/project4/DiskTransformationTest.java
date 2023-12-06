package edu.project4;

import edu.project4.functions.DiskTransformation;
import edu.project4.functions.Transformation;
import edu.project4.entities.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class DiskTransformationTest {
    @Test
    @DisplayName("Test disk transformation")
    public void testDisk() {
        Transformation diskTransformation = new DiskTransformation();

        Point expected = new Point(-0.12770684781648475, -0.32846349503275585);

        Point response = diskTransformation.apply(new Point(0.5, 1));

        assertThat(expected).isEqualTo(response);
    }
}
