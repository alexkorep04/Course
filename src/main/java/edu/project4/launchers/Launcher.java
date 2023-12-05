package edu.project4.launchers;

import edu.project4.Functions.Transformation;
import edu.project4.correcions.GammaCorrection;
import edu.project4.correcions.ImageProcessor;
import edu.project4.entities.FractalImage;
import edu.project4.entities.ImageFormat;
import edu.project4.entities.Rectangular;
import edu.project4.renders.Renderer;
import edu.project4.utils.Saver;
import java.nio.file.Path;
import java.util.List;

public class Launcher {
    private Launcher() {
    }

    @SuppressWarnings("MagicNumber")
    public static void generateFractalImage(int width, int height, Renderer renderer,
        Rectangular world, List<Transformation> transformations, ImageFormat imageFormat, Path path) {
        FractalImage fractalImage = FractalImage.createImage(width, height);
        renderer.render(fractalImage, world, transformations, 10, 1000000, 11);
        ImageProcessor imageProcessor = new GammaCorrection();
        imageProcessor.process(fractalImage);
        Saver.saveImage(path, imageFormat, fractalImage);
    }
}
