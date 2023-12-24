package edu.project4.functions;

import edu.project4.entities.Point;

public class DiamondTransformation implements Transformation {
    @Override
    public Point apply(Point point) {
        double x = point.x();
        double y = point.y();
        double theta = Math.atan(y / x);
        double sqrt = Math.sqrt(x * x + y * y);
        double newX = Math.sin(theta) * Math.cos(sqrt);
        double newY = Math.cos(theta) * Math.sin(sqrt);
        return new Point(newX, newY);
    }
}
