package edu.project4;

import edu.project4.Functions.HeartTransformation;
import edu.project4.entities.FractalImage;
import edu.project4.entities.Rectangular;
import edu.project4.renders.MultiThreadRenderer;
import edu.project4.renders.SingleThreadRenderer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

public class RenderTest {
    @Test
    @DisplayName("Test of single thread renderer")
    public void testSingleRender() {
        Assertions.assertDoesNotThrow(() ->
            new SingleThreadRenderer().render(
                FractalImage.createImage(1920, 1080),
                new Rectangular(-4, -3, 8, 6),
                List.of(
                    new HeartTransformation()
                ),
                10, 10000, 8)
        );
    }

    @Test
    @DisplayName("Test of multi thread renderer")
    public void testMultiThreadRender() {
        Assertions.assertDoesNotThrow(() ->
            new MultiThreadRenderer().render(
                FractalImage.createImage(1920, 1080),
                new Rectangular(-4, -3, 8, 6),
                List.of(
                    new HeartTransformation()
                ),
                10, 10000, 8)
        );
    }
}
