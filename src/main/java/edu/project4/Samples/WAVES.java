package edu.project4.Samples;

import edu.project4.Fractal;
import edu.project4.Point;

public class WAVES implements Fractal {
    @Override
    public Point apply( Point point) {
        return new Point(
            point.x() + coefficients.b() * Math.sin(point.y() / coefficients.c() * coefficients.c()),
            point.y() + coefficients.e() * Math.sin(point.x() / coefficients.f() * coefficients.f())
        );
    }
}
