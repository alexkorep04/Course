package edu.hw10.task1.generators;

import edu.hw10.task1.Max;
import edu.hw10.task1.Min;
import java.lang.annotation.Annotation;
import java.util.Random;

public class DoubleGenerator implements Generator {
    private Random random = new Random();

    @Override
    public Double generate(Annotation[] annotations) {
        double minVal = Double.MIN_VALUE;
        double maxVal = Double.MAX_VALUE;
        for (Annotation annotation: annotations) {
            if (annotation instanceof Max) {
                maxVal = (double) ((Max) annotation).value();
            } else if (annotation instanceof Min) {
                minVal = (double) ((Min) annotation).value();
            }
        }
        return random.nextDouble(minVal, maxVal);
    }
}
