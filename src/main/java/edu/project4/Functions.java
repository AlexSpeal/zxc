package edu.project4;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Functions {
    private Functions() {
    }

    private static Coefficients defaultCoefficients = new Coefficients(1, 0, 0, 0, 1, 0);

    private static int defaultWeight = 1;

    private static final List<Function> FUNCTIONS = List.of(
        new Function(
            Coefficients.randomCoefficients(),
            new RGB(),
            List.of(
                new Options(ThreadLocalRandom.current().nextInt(1, 3), Fractals.HEART),
                new Options(ThreadLocalRandom.current().nextInt(1, 3), Fractals.EXPONENTIAL),
                new Options(ThreadLocalRandom.current().nextInt(1, 3), Fractals.POPCORN),
                new Options(ThreadLocalRandom.current().nextInt(1, 3), Fractals.SWIRL),
                new Options(ThreadLocalRandom.current().nextInt(1, 3), Fractals.DISC)
            )
        ),
        new Function(
            Coefficients.randomCoefficients(),
            new RGB(),
            List.of(
                new Options(ThreadLocalRandom.current().nextInt(1, 3), Fractals.HEART),
                new Options(ThreadLocalRandom.current().nextInt(1, 3), Fractals.DIAMOND)
            )
        ),
        new Function(
            Coefficients.randomCoefficients(),
            new RGB(),
            List.of(
                new Options(ThreadLocalRandom.current().nextInt(1, 3), Fractals.HORSESHO),
                new Options(ThreadLocalRandom.current().nextInt(1, 3), Fractals.HANDKERCHIEF)
            )
        ),
        new Function(
            Coefficients.randomCoefficients(),
            new RGB(),
            List.of(
                new Options(ThreadLocalRandom.current().nextInt(1, 3), Fractals.HEART),
                new Options(ThreadLocalRandom.current().nextInt(1, 3), Fractals.SPIRAL)
            )
        ),
        new Function(
            Coefficients.randomCoefficients(),
            new RGB(),
            List.of(
                new Options(ThreadLocalRandom.current().nextInt(1, 3), Fractals.SPIRAL),
                new Options(ThreadLocalRandom.current().nextInt(1, 3), Fractals.HYPERBOLIC)
            )
        )
    );

    public static Function getFunction() {
        return FUNCTIONS.get(ThreadLocalRandom.current().nextInt(FUNCTIONS.size()));
    }
}
