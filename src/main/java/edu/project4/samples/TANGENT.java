package edu.project4.samples;

import edu.project4.Coefficients;
import edu.project4.Point;

public class TANGENT implements Fractal {
    @Override
    public Point apply(Coefficients coefficients, Point point) {
        return new Point(
            Math.sin(point.x()) / Math.cos(point.y()),
            Math.tan(point.y())
        );
    }
}
