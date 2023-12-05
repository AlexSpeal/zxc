package edu.project4;

import edu.project4.Samples.DIAMOND;
import edu.project4.Samples.DISC;
import edu.project4.Samples.EXPONENTIAL;
import edu.project4.Samples.HEART;
import edu.project4.Samples.HYPERBOLIC;
import edu.project4.Samples.SPIRAL;
import java.util.List;
import java.util.Random;

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
           List.of(new HEART(), new EXPONENTIAL())
       ),
       new Function(Coefficients.randomCoefficients(), new RGB(),
           List.of(new HEART(), new EXPONENTIAL(), new DISC())
       ),
       new Function(Coefficients.randomCoefficients(), new RGB(),
           List.of(new HEART(), new DIAMOND())
       ),
       new Function(Coefficients.randomCoefficients(), new RGB(),
           List.of(new HEART(), new SPIRAL())
       ),
       new Function(Coefficients.randomCoefficients(), new RGB(),
           List.of(new SPIRAL(), new HYPERBOLIC())
       ),
       new Function(Coefficients.randomCoefficients(), new RGB(),
           List.of( new DISC(), new HEART())
       ),
       new Function(Coefficients.randomCoefficients(), new RGB(),
           List.of(new DIAMOND(), new HEART())
       ));

    public static Function getRandomFunction() {
        Random r = new Random();
        int random = r.nextInt(FunctionList.size());
        return FunctionList.get(random);
    }
}
