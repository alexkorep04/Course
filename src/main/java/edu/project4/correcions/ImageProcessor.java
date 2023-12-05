package edu.project4.correcions;

import edu.project4.entities.FractalImage;

@FunctionalInterface
public interface ImageProcessor {
    void process(FractalImage image);
}
