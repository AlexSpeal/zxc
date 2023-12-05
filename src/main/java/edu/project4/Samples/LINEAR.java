package edu.project4.Samples;

import edu.project4.Fractal;
import edu.project4.Point;

public class LINEAR implements Fractal {
    @Override
    public Point apply( Point point) {
        return new Point(point.x(), point.y());
    }
}
