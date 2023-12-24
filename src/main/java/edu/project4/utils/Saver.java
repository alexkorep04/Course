package edu.project4.utils;

import edu.project4.entities.FractalImage;
import edu.project4.entities.ImageFormat;
import edu.project4.entities.Pixel;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Path;
import javax.imageio.ImageIO;

public class Saver {
    private Saver() {
    }

    public static void saveImage(Path path, ImageFormat imageFormat, FractalImage image) {
        BufferedImage bufferedImage =
            new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);
        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {
                Pixel pixel = image.getPixel(i, j);
                Color color = new Color(pixel.getR(), pixel.getG(), pixel.getB());
                bufferedImage.setRGB(i, j, color.getRGB());
            }
        }
        try {
            ImageIO.write(bufferedImage, imageFormat.name(), path.toFile());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
