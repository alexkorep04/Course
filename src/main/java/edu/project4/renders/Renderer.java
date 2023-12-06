package edu.project4.renders;

import edu.project4.entities.FractalImage;
import edu.project4.entities.Rectangular;
import edu.project4.functions.Transformation;
import java.util.List;

public interface Renderer {
    FractalImage render(
        FractalImage canvas,
        Rectangular world,
        List<Transformation> transformations,
        int samples,
        int iterPerSample,
        int symmetry
    );
}
