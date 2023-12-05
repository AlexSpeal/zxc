package edu.project4.Samples;

import edu.project4.Fractal;
import edu.project4.Point;

public class HANDKERCHIEF implements Fractal {
    @Override
    public Point apply( Point point) {
        double r = Math.sqrt(point.x() * point.x() + point.y() * point.y());
        double theta = Math.atan(point.x() / point.y());
        return new Point(r * Math.sin(theta + r), r * Math.cos(theta - r));
    }
}