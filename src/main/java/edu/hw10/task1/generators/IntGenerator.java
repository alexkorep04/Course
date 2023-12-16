package edu.hw10.task1.generators;

import edu.hw10.task1.Max;
import edu.hw10.task1.Min;
import java.lang.annotation.Annotation;
import java.util.Random;

public class IntGenerator implements Generator {
    private Random random = new Random();

    @Override
    public Integer generate(Annotation[] annotations) {
        int minVal = Integer.MIN_VALUE;
        int maxVal = Integer.MAX_VALUE;
        for (Annotation annotation: annotations) {
            if (annotation instanceof Max) {
                maxVal = (int) ((Max) annotation).value();
            } else if (annotation instanceof Min) {
                minVal = (int) ((Min) annotation).value();
            }
        }
        if(minVal > maxVal) {
            minVal += maxVal;
            maxVal = minVal - maxVal;
            minVal -= maxVal;
        }
        return random.nextInt(minVal, maxVal);
    }
}
