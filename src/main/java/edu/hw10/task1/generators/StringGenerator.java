package edu.hw10.task1.generators;

import java.lang.annotation.Annotation;
import java.util.Random;

public class StringGenerator implements Generator {
    private Random random = new Random();
    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    @SuppressWarnings("MagicNumber")
    @Override
    public Object generate(Annotation[] annotations) {
        int length = random.nextInt(1, 15);
        StringBuilder randomString = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            randomString.append(CHARACTERS.charAt(randomIndex));
        }
        return randomString.toString();
    }
}
