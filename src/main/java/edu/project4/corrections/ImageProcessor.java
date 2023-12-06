package edu.project4.corrections;

import edu.project4.entities.FractalImage;

@FunctionalInterface
public interface ImageProcessor {
    void process(FractalImage image);
}
