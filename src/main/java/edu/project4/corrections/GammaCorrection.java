package edu.project4.corrections;

import edu.project4.entities.FractalImage;
import edu.project4.entities.Pixel;

public class GammaCorrection implements ImageProcessor {

    @SuppressWarnings("MagicNumber")
    @Override
    public void process(FractalImage image) {
        double max = 0;
        double gamma = 2.3;
        for (int row = 0; row < image.getWidth(); row++) {
            for (int col = 0; col < image.getHeight(); col++) {
                Pixel pixel = image.getPixel(row, col);
                if (pixel.getHitCount() != 0) {
                    pixel.setNormal(Math.log10(pixel.getHitCount()));
                    max = Math.max(max, pixel.getNormal());
                }
            }
        }
        for (int row = 0; row < image.getWidth(); row++) {
            for (int col = 0; col < image.getHeight(); col++) {
                Pixel pixel = image.getPixel(row, col);
                pixel.setNormal(pixel.getNormal() / max);
                pixel.setR((int) (pixel.getR() * Math.pow(pixel.getNormal(), (1.0 / gamma))));
                pixel.setG((int) (pixel.getG() * Math.pow(pixel.getNormal(), (1.0 / gamma))));
                pixel.setB((int) (pixel.getB() * Math.pow(pixel.getNormal(), (1.0 / gamma))));
            }
        }
    }
}
