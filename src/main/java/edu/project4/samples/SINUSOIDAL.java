package edu.project4.samples;

import edu.project4.Coefficients;
import edu.project4.Point;

public class SINUSOIDAL implements Fractal {
    @Override
    public Point apply(Coefficients coefficients, Point point) {
        return new Point(Math.sin(point.x()), Math.sin(point.y()));
    }
}
