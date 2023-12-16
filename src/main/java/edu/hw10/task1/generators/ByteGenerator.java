package edu.hw10.task1.generators;

import edu.hw10.task1.Max;
import edu.hw10.task1.Min;
import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.Random;

public class ByteGenerator implements Generator {
    private Random random = new Random();

    @Override
    public Byte generate(Annotation[] annotations) {
        byte minVal = Byte.MIN_VALUE;
        byte maxVal = Byte.MAX_VALUE;
        for (Annotation annotation: annotations) {
            if (annotation instanceof Max) {
                maxVal = (byte) ((Max) annotation).value();
            } else if (annotation instanceof Min) {
                minVal = (byte) ((Min) annotation).value();
            }
        }
        if(minVal > maxVal) {
            minVal += maxVal;
            maxVal = (byte) (minVal - maxVal);
            minVal -= maxVal;
        }
        return (byte) random.nextInt(minVal, maxVal);
    }
}
