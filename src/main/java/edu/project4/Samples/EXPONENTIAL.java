package edu.project4.Samples;

import edu.project4.Coefficients;
import edu.project4.Fractal;
import edu.project4.Point;

public class EXPONENTIAL implements Fractal {
    @Override
    public Point apply(Coefficients coefficients, Point point) {
        return new Point(
            Math.exp(point.x() - 1) * Math.cos(Math.PI * point.y()),
            Math.exp(point.x() - 1) * Math.sin(Math.PI * point.y())
        );
    }
}
