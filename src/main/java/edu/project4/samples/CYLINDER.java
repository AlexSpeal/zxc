package edu.project4.samples;

import edu.project4.Coefficients;
import edu.project4.Point;

@SuppressWarnings("MagicNumber")
public class CYLINDER implements Fractal {
    @Override
    public Point apply(Coefficients coefficients, Point point) {
        return new Point(Math.sin(point.x()), point.y());
    }
}
