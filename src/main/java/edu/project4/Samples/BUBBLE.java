package edu.project4.Samples;

import edu.project4.Fractal;
import edu.project4.Point;

public class BUBBLE implements Fractal {
    @Override
    public Point apply(Point point) {
        double rSquared = point.x() * point.x() + point.y() * point.y();
        return new Point(4 * point.x() / (rSquared + 4), 4 * point.y() / (rSquared + 4));
    }
}
