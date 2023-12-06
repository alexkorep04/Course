package edu.project4;

import edu.project4.functions.SwirlTransformation;
import edu.project4.functions.Transformation;
import edu.project4.entities.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class SwirlTransformationTest {
    @Test
    @DisplayName("Test swirl transformation")
    public void testSwirl() {
        Transformation swirlTransformation = new SwirlTransformation();

        Point expected = new Point(0.15916994728252443, 1.1066458005532205);

        Point response = swirlTransformation.apply(new Point(0.5, 1));

        assertThat(expected).isEqualTo(response);
    }
}
