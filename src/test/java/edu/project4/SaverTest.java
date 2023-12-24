package edu.project4;

import edu.project4.entities.FractalImage;
import edu.project4.entities.ImageFormat;
import edu.project4.utils.Saver;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class SaverTest {
    @Test
    @DisplayName("Test saver by saving files")
    public void testSaver() throws IOException {
        Files.deleteIfExists(Path.of("testImage.bmp"));
        Saver.saveImage(Path.of("testImage.bmp"), ImageFormat.BMP, FractalImage.createImage(1920, 1080));

        assertThat(Path.of("testImage.bmp")).exists();
    }
}
