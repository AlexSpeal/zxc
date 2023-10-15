package edu.hw2;

import org.apache.logging.log4j.LogManager;
import edu.hw2.Expr;

@SuppressWarnings("uncommentedmain")
public class task1 {

    private task1() {

    }

    private final static org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) {
        var two = new Expr.Constant(2);
        var four = new Expr.Constant(4);
        var negOne = new Expr.Negate(new Expr.Constant(1));
        var sumTwoFour = new Expr.Addition(two, four);
        var mult = new Expr.Multiplication(sumTwoFour, negOne);
        var exp = new Expr.Exponent(mult, 2);
        var res = new Expr.Addition(exp, new Expr.Constant(1));

        System.out.println(res + " = " + res.evaluate());

    }
}
