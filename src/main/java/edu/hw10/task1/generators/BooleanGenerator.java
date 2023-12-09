package edu.hw10.task1.generators;

import java.lang.annotation.Annotation;
import java.util.Random;

public class BooleanGenerator implements Generator {
    private Random random = new Random();

    @Override
    public Object generate(Annotation[] annotations) {
        return random.nextBoolean();
    }
}
