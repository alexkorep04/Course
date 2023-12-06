package edu.project4.renders;

import edu.project4.entities.AffineCoeffs;
import edu.project4.entities.FractalImage;
import edu.project4.entities.Pixel;
import edu.project4.entities.Point;
import edu.project4.entities.Rectangular;
import edu.project4.functions.Transformation;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class SingleThreadRenderer implements Renderer {
    protected AffineCoeffs[] generateCoefficients(int samples) {
        AffineCoeffs[] coefficients = new AffineCoeffs[samples];
        for (int i = 0; i < samples; i++) {
            coefficients[i] = AffineCoeffs.create();
        }
        return coefficients;
    }

    protected Point getPointAfterAffineTransformation(AffineCoeffs coefficients, Point pw) {
        double newX = coefficients.a() * pw.x() + coefficients.b() * pw.y()
            + coefficients.c();
        double newY = coefficients.d() * pw.x() + coefficients.e() * pw.y()
            + coefficients.f();
        return new Point(newX, newY);
    }

    protected AffineCoeffs getRandomCoefficient(AffineCoeffs[] coefficientsArray) {
        int randomIndex = ThreadLocalRandom.current().nextInt(0, coefficientsArray.length);
        return coefficientsArray[randomIndex];
    }

    protected Transformation getRandomTransformation(List<Transformation> transformations) {
        return transformations.get(ThreadLocalRandom.current().nextInt(0, transformations.size()));
    }

    protected Point getRotatedPoint(Point pw, double theta) {
        double xRot = pw.x() * Math.cos(theta) - pw.y() * Math.sin(theta);
        double yRot = pw.x() * Math.sin(theta) + pw.y() * Math.cos(theta);
        return new Point(xRot, yRot);
    }

    protected void setPixelColor(Pixel pixel, AffineCoeffs coefficients) {
        if (pixel.getHitCount() == 0) {
            pixel.setR(coefficients.color().getRed());
            pixel.setG(coefficients.color().getGreen());
            pixel.setB(coefficients.color().getBlue());
        } else {
            pixel.setR((pixel.getR() + coefficients.color().getRed()) / 2);
            pixel.setG((pixel.getG() + coefficients.color().getGreen()) / 2);
            pixel.setB((pixel.getB() + coefficients.color().getBlue()) / 2);
        }
    }

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
                Pixel pixel =
                    canvas.getPixel(
                        (int) ((pwr.x() - world.x()) * canvas.getWidth() / world.width()),
                        (int) ((pwr.y() - world.y()) * canvas.getHeight() / world.height())
                    );
                if (pixel == null) {
                    continue;
                }
                setPixelColor(pixel, randomCoefficients);
                pixel.setHitCount(pixel.getHitCount() + 1);
            }
        }
    }

    @Override
    public FractalImage render(
        FractalImage canvas, Rectangular world, List<Transformation> transformations,
        int samples, int iterPerSample, int symmetry
    ) {
        AffineCoeffs[] coefficientsArray = generateCoefficients(samples);
        for (int num = 0; num < samples; num++) {
            doIterations(canvas, world, transformations, coefficientsArray, iterPerSample, symmetry);
        }
        return canvas;
    }
}
