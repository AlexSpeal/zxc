package edu.project4.Samples;

import edu.project4.Coefficients;
import edu.project4.Fractal;
import edu.project4.Point;

public class HORSESHO implements Fractal {
    @Override
    public Point apply(Coefficients coefficients,Point point) {
        double r = Math.sqrt(point.x() * point.x() + point.y() * point.y());
        return new Point(
            (point.x() * point.x() - point.y() * point.y()) / r,
            2 * point.x() * point.y() / r
        );
    }
}
