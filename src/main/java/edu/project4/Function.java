package edu.project4;

import edu.project4.samples.Fractal;
import java.util.List;

public record Function(Coefficients coefficients, RGB rgb, List<Fractal> fractals) {
}
