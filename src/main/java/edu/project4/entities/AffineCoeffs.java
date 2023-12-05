package edu.project4.entities;

import java.awt.Color;
import java.util.concurrent.ThreadLocalRandom;

public record AffineCoeffs(double a, double b, double c, double d, double e, double f, Color color) {

    private static final int COLOR_BOUND = 255;

    public static AffineCoeffs create() {
        double a = ThreadLocalRandom.current().nextDouble(-1, 1);
        double b = ThreadLocalRandom.current().nextDouble(-1, 1);
        double c = ThreadLocalRandom.current().nextDouble(-1, 1);
        double d = ThreadLocalRandom.current().nextDouble(-1, 1);
        double e = ThreadLocalRandom.current().nextDouble(-1, 1);
        double f = ThreadLocalRandom.current().nextDouble(-1, 1);
        while (!areCoefsValid(a, b, c, d, e, f)) {
            a = ThreadLocalRandom.current().nextDouble(-1, 1);
            b = ThreadLocalRandom.current().nextDouble(-1, 1);
            c = ThreadLocalRandom.current().nextDouble(-1, 1);
            d = ThreadLocalRandom.current().nextDouble(-1, 1);
            e = ThreadLocalRandom.current().nextDouble(-1, 1);
            f = ThreadLocalRandom.current().nextDouble(-1, 1);
        }
        return new AffineCoeffs(a, b, c, d, e, f,
            new Color(ThreadLocalRandom.current().nextInt(0, COLOR_BOUND),
                ThreadLocalRandom.current().nextInt(0, COLOR_BOUND),
                ThreadLocalRandom.current().nextInt(0, COLOR_BOUND)));
    }

    private static boolean areCoefsValid(double a, double b, double c, double d, double e, double f) {
        return (a * a + d * d < 1)
            && (b * b + e * e < 1)
            && (a * a + b * b + d * d + e * e < 1 + (a * e - b * d) * (a * e - b * d));
    }
}
