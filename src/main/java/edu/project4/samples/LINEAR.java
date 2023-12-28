package edu.project4.samples;

import edu.project4.Coefficients;
import edu.project4.Point;

public class LINEAR implements Fractal {
    @Override
    public Point apply(Coefficients coefficients, Point point) {
        return new Point(point.x(), point.y());
    }
}
