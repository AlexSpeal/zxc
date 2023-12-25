package edu.project4.samples;

import edu.project4.Coefficients;
import edu.project4.Point;

public class SWIRL implements Fractal {
    @Override
    public Point apply(Coefficients coefficients, Point point) {
        double rSquared = point.x() * point.x() + point.y() * point.y();
        double sinRSquared = Math.sin(rSquared);
        double cosRSquared = Math.cos(rSquared);
        return new Point(
            point.x() * sinRSquared - point.y() * cosRSquared,
            point.x() * cosRSquared + point.y() * sinRSquared
        );
    }
}
