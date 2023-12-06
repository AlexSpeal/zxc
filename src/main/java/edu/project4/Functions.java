package edu.project4;

import edu.project4.Samples.BUBBLE;
import edu.project4.Samples.CYLINDER;
import edu.project4.Samples.DISC;
import edu.project4.Samples.EXPONENTIAL;
import edu.project4.Samples.FISHEYE;
import edu.project4.Samples.HEART;
import edu.project4.Samples.SPHERICAL;
import edu.project4.Samples.SPIRAL;
import edu.project4.Samples.SWIRL;
import edu.project4.Samples.TANGENT;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Functions {
    private Functions() {

    }

    /* private final static List<Function> FuctionList =
         List.of(
             new Function(Coefficients.randomCoefficients(), new RGB(), List.of(new DISC(), new HEART(), new EYEFISH())),
             new Function(
                 Coefficients.randomCoefficients(),
                 new RGB(),
                 List.of(new HANDKERCHIEF(), new SPIRAL(), new BUBBLE(), new TANGENT(), new HEART())
             ),
             new Function(
                 Coefficients.randomCoefficients(),
                 new RGB(),
                 List.of(new TANGENT(), new DIAMOND(), new EXPONENTIAL())
             ),
             new Function(
                 Coefficients.randomCoefficients(),
                 new RGB(),
                 List.of(new HYPERBOLIC(), new HEART(), new EYEFISH())
             ), new Function(
                 Coefficients.randomCoefficients(),
                 new RGB(),
                 List.of(new HEART(), new TANGENT(), new EXPONENTIAL())
             ), new Function(
                 Coefficients.randomCoefficients(),
                 new RGB(),
                 List.of(new SWIRL(), new HEART(), new HYPERBOLIC())
             )
         );*/
    private static final List<Function> FunctionList = List.of(
        new Function(Coefficients.randomCoefficients(), new RGB(),
            List.of(new EXPONENTIAL(), new SWIRL())
        ),
        new Function(Coefficients.randomCoefficients(), new RGB(),
            List.of(new HEART(), new EXPONENTIAL(), new DISC())
        ),
        new Function(Coefficients.randomCoefficients(), new RGB(),
            List.of(new TANGENT(), new FISHEYE(), new BUBBLE())
        ),
        new Function(Coefficients.randomCoefficients(), new RGB(),
            List.of(new HEART())
        ),
        new Function(Coefficients.randomCoefficients(), new RGB(),
            List.of(new SPIRAL(), new SPHERICAL())
        ),
        new Function(Coefficients.randomCoefficients(), new RGB(),
            List.of(new FISHEYE())
        ),
        new Function(Coefficients.randomCoefficients(), new RGB(),
            List.of(new SWIRL(), new TANGENT(), new CYLINDER())
        )
    );

    public static Function getRandomFunction() {
        return FunctionList.get(ThreadLocalRandom.current().nextInt(FunctionList.size()));
    }
}
