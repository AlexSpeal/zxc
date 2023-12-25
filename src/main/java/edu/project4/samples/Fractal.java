package edu.project4.samples;

import edu.project4.Coefficients;
import edu.project4.Point;

public interface Fractal {
    Point apply(Coefficients coefficients, Point point);
}
