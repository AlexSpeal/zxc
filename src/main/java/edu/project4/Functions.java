package edu.project4;

import edu.project4.Samples.BUBBLE;
import edu.project4.Samples.DISC;
import edu.project4.Samples.HORSESHO;
import edu.project4.Samples.TANGENT;
import edu.project4.Samples.WAVES;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Functions {
    private Functions() {

    }

    private static final List<Function> FUNCTIONLIST = List.of(
        new Function(Coefficients.randomCoefficients(), new RGB(),
            List.of(new HORSESHO())
        ),
        new Function(Coefficients.randomCoefficients(), new RGB(),
            List.of(new TANGENT(), new BUBBLE())
        ),
        new Function(Coefficients.randomCoefficients(), new RGB(),
            List.of(new WAVES(), new DISC())
        )
    );

    public static Function getRandomFunction() {
        return FUNCTIONLIST.get(ThreadLocalRandom.current().nextInt(FUNCTIONLIST.size()));
    }
}
