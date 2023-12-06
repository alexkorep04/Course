package edu.project4;

import edu.project4.corrections.GammaCorrection;
import edu.project4.entities.FractalImage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class GammaCorrectionTest {
    @Test
    @DisplayName("Test of gamma correction")
    public void testGamma() {
        Assertions.assertDoesNotThrow(() ->
            new GammaCorrection().process(FractalImage.createImage(1920, 1080))
        );
    }
}
