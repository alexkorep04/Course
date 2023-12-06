package edu.project4.functions;

import edu.project4.entities.Point;

public class DiskTransformation implements Transformation {
    @Override
    public Point apply(Point point) {
        double x = point.x();
        double y = point.y();
        double newX = 1.0 / Math.PI * Math.atan(y / x) * Math.sin(Math.PI * Math.sqrt(x * x + y * y));
        double newY = 1.0 / Math.PI * Math.atan(y / x) * Math.cos(Math.PI * Math.sqrt(x * x + y * y));
        return new Point(newX, newY);
    }
}
