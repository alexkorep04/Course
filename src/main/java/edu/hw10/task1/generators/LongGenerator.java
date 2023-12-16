package edu.hw10.task1.generators;

import edu.hw10.task1.Max;
import edu.hw10.task1.Min;
import java.lang.annotation.Annotation;
import java.util.Random;

public class LongGenerator implements Generator {
    private Random random = new Random();

    @Override
    public Long generate(Annotation[] annotations) {
        long minVal = Long.MIN_VALUE;
        long maxVal = Long.MAX_VALUE;
        for (Annotation annotation: annotations) {
            if (annotation instanceof Max) {
                maxVal = (long) ((Max) annotation).value();
            } else if (annotation instanceof Min) {
                minVal = (long) ((Min) annotation).value();
            }
        }
        if(minVal > maxVal) {
            minVal += maxVal;
            maxVal = minVal - maxVal;
            minVal -= maxVal;
        }
        return random.nextLong(minVal, maxVal);
    }
}
