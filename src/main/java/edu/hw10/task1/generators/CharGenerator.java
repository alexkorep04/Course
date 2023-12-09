package edu.hw10.task1.generators;

import edu.hw10.task1.Max;
import edu.hw10.task1.Min;
import java.lang.annotation.Annotation;
import java.util.Random;

public class CharGenerator implements Generator {
    private Random random = new Random();

    @Override
    public Character generate(Annotation[] annotations) {
        char minVal = Character.MIN_VALUE;
        char maxVal = Character.MAX_VALUE;
        for (Annotation annotation: annotations) {
            if (annotation instanceof Max) {
                maxVal = (char) ((Max) annotation).value();
            } else if (annotation instanceof Min) {
                minVal = (char) ((Min) annotation).value();
            }
        }
        return (char) random.nextInt(minVal, maxVal);
    }
}
