package edu.project4.Samples;

import edu.project4.Fractal;
import edu.project4.Point;

public class SPHERICAL implements Fractal {
    @Override
    public Point apply( Point point) {
        double rSquared = point.x() * point.x() + point.y() * point.y();
        return new Point(point.x() / rSquared, point.y() / rSquared);
    }
}
