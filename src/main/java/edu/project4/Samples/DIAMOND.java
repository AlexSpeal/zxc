package edu.project4.Samples;

import edu.project4.Fractal;
import edu.project4.Point;

public class DIAMOND implements Fractal {
    @Override
    public Point apply( Point point) {
        double r = Math.sqrt(point.x() * point.x() + point.y() * point.y());
        double theta = Math.atan(point.x() / point.y());
        return new Point(Math.sin(theta) * Math.cos(r), Math.cos(theta) * Math.sin(r));
    }
}
