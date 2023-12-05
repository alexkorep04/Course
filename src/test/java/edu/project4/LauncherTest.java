package edu.project4;

import edu.project4.Functions.DiskTransformation;
import edu.project4.Functions.HeartTransformation;
import edu.project4.Functions.PolarTransformation;
import edu.project4.Functions.SinusTransformation;
import edu.project4.Functions.SphereTransformation;
import edu.project4.entities.ImageFormat;
import edu.project4.entities.Rectangular;
import edu.project4.launchers.Launcher;
import edu.project4.renders.MultiThreadRenderer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.nio.file.Path;
import java.util.List;

public class LauncherTest {
    @Test
    @DisplayName("Test of launcher")
    public void testGamma() {
        Assertions.assertDoesNotThrow(() ->
            Launcher.generateFractalImage(1920, 1080, new MultiThreadRenderer(), new Rectangular(-4, -3, 8, 6), List.of(new DiskTransformation()),
                ImageFormat.JPEG, Path.of("1.jpeg")));
    }
}
