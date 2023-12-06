package edu.project4.renders;

import edu.project4.entities.AffineCoeffs;
import edu.project4.entities.FractalImage;
import edu.project4.entities.Pixel;
import edu.project4.entities.Point;
import edu.project4.entities.Rectangular;
import edu.project4.functions.Transformation;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadRenderer extends SingleThreadRenderer {
    private final ExecutorService executorService = Executors.newFixedThreadPool(12);

    @SuppressWarnings("MagicNumber")
    private void doIterations(FractalImage canvas, Rectangular world, List<Transformation> transformations,
        AffineCoeffs[] coefficientsArray, int iterPerSample, int symmetry) {
        Point pw = world.getPoint();
        for (int step = -20; step < iterPerSample; step++) {
            AffineCoeffs randomCoefficients = getRandomCoefficient(coefficientsArray);
            pw = getPointAfterAffineTransformation(randomCoefficients, pw);
            Transformation transformation = getRandomTransformation(transformations);
            pw = transformation.apply(pw);
            double theta = 0.0;
            for (int s = 0; s < symmetry; theta += 2 * Math.PI / symmetry, s++) {
                Point pwr = getRotatedPoint(pw, theta);
                if (!world.isContains(pwr)) {
                    continue;
                }
                Pixel pixel = canvas.getPixel((int) ((pwr.x() - world.x()) * canvas.getWidth() / world.width()),
                        (int) ((pwr.y() - world.y()) * canvas.getHeight() / world.height()));
                if (pixel == null) {
                    continue;
                }
                synchronized (pixel) {
                    setPixelColor(pixel, randomCoefficients);
                    pixel.setHitCount(pixel.getHitCount() + 1);
                }
            }
        }
    }

    @Override
    public FractalImage render(
        FractalImage canvas, Rectangular world, List<Transformation> transformations,
        int samples, int iterPerSample, int symmetry
    )  {
        AffineCoeffs[] coefficientsArray = generateCoefficients(samples);
        for (int num = 0; num < samples; num++) {
            executorService.execute(() -> {
                doIterations(canvas, world, transformations, coefficientsArray, iterPerSample, symmetry);
            });
        }
        executorService.shutdown();
        executorService.close();
        return canvas;
    }
}
