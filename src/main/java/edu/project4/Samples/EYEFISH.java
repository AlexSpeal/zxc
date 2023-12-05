package edu.project4.Samples;

import edu.project4.Fractal;
import edu.project4.Point;

public class EYEFISH implements Fractal {
    @Override
    public Point apply( Point point) {
        double r = Math.sqrt(point.x() * point.x() + point.y() * point.y());
        return new Point(2 * point.x() / (r + 1), 2 * point.y() / (r + 1));
    }
}
