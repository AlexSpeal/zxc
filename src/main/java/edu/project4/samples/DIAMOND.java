package edu.project4.samples;

import edu.project4.Coefficients;
import edu.project4.Point;

@SuppressWarnings("MagicNumber")
public class DIAMOND implements Fractal {
    @Override
    public Point apply(Coefficients coefficients, Point point) {
        double r = Math.sqrt(point.x() * point.x() + point.y() * point.y());
        double theta = Math.atan(point.x() / point.y());
        return new Point(Math.sin(theta) * Math.cos(r), Math.cos(theta) * Math.sin(r));
    }
}
