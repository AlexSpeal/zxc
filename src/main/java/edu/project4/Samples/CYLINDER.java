package edu.project4.Samples;

import edu.project4.Fractal;
import edu.project4.Point;

public class CYLINDER implements Fractal {
    @Override
    public Point apply(Point point) {
        return new Point(Math.sin(point.x()), point.y());
    }
}
