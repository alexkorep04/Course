package edu.hw10.task1.generators;

import edu.hw10.task1.Max;
import edu.hw10.task1.Min;
import java.lang.annotation.Annotation;
import java.util.Random;

public class FloatGenerator implements Generator {
    private Random random = new Random();

    @Override
    public Float generate(Annotation[] annotations) {
        float minVal = Float.MIN_VALUE;
        float maxVal = Float.MAX_VALUE;
        for (Annotation annotation: annotations) {
            if (annotation instanceof Max) {
                maxVal = (float) ((Max) annotation).value();
            } else if (annotation instanceof Min) {
                minVal = (float) ((Min) annotation).value();
            }
        }
        if  (minVal > maxVal) {
            minVal += maxVal;
            maxVal = minVal - maxVal;
            minVal -= maxVal;
        }
        return random.nextFloat(minVal, maxVal);
    }
}
