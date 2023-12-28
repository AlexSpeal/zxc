package edu.project4.samples;

import edu.project4.Coefficients;
import edu.project4.Point;

@SuppressWarnings("MagicNumber")
public class BUBBLE implements Fractal {
    @Override
    public Point apply(Coefficients coefficients, Point point) {
        double rSquared = point.x() * point.x() + point.y() * point.y();
        return new Point(4 * point.x() / (rSquared + 4), 4 * point.y() / (rSquared + 4));
    }
}
