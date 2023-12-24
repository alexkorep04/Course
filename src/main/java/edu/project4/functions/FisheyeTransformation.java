package edu.project4.functions;

import edu.project4.entities.Point;

public class FisheyeTransformation implements Transformation {
    @Override
    public Point apply(Point point) {
        double x = point.x();
        double y = point.y();
        double sqrt = Math.sqrt(x * x + y * y);
        double newX = 2 / (sqrt + 1) * y;
        double newY = 2 / (sqrt + 1) * x;
        return new Point(newX, newY);
    }
}
