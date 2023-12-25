package edu.project4.samples;

import edu.project4.Coefficients;
import edu.project4.Point;

@SuppressWarnings("MagicNumber")
public class EYEFISH implements Fractal {
    @Override
    public Point apply(Coefficients coefficients, Point point) {
        double r = Math.sqrt(point.x() * point.x() + point.y() * point.y());
        return new Point(2 * point.x() / (r + 1), 2 * point.y() / (r + 1));
    }
}
