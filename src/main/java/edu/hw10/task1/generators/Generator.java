package edu.hw10.task1.generators;

import java.lang.annotation.Annotation;

public interface Generator<V> {
    V generate(Annotation[] annotations);
}
