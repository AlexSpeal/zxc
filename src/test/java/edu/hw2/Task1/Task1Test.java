package edu.hw2.Task1;

import edu.hw2.Task1.Expr;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Task1Test {
    @Test
    @DisplayName("тест суммы")
    void test0() {
        var two = new Expr.Constant(2);
        var four = new Expr.Constant(4);
        var negOne = new Expr.Negate(new Expr.Constant(1));
        var sumTwoFour = new Expr.Addition(two, four);
        var mult = new Expr.Multiplication(sumTwoFour, negOne);
        var exp = new Expr.Exponent(mult, 2);
        double actual = new Expr.Addition(exp, new Expr.Constant(1)).evaluate();
        double expected =37;
        assertEquals(expected, actual);
    }
    @Test
    @DisplayName("метод Constant")
    void test1() {
        double actual = new Expr.Constant(-1).evaluate();
        double expected = -1;
        assertEquals(expected, actual);

        actual = new Expr.Constant(10).evaluate();
        expected = 10;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("метод Addition")
    void test2() {
        double actual = new Expr.Addition(new Expr.Constant(5), new Expr.Constant(5)).evaluate();
        double expected = 10;
        assertEquals(expected, actual);

        actual = new Expr.Addition(new Expr.Constant(-5), new Expr.Constant(5)).evaluate();
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("метод Negate")
    void test3() {
        double actual = new Expr.Negate(new Expr.Constant(5)).evaluate();
        double expected = -5;
        assertEquals(expected, actual);

        actual = new Expr.Negate(new Expr.Constant(-4)).evaluate();
        expected = 4;
        assertEquals(expected, actual);

        actual = new Expr.Negate(new Expr.Constant(0)).evaluate();
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("метод Multiplication")
    void test4() {
        double actual = new Expr.Multiplication(new Expr.Constant(5), new Expr.Constant(5)).evaluate();
        double expected = 25;
        assertEquals(expected, actual);

        actual = new Expr.Multiplication(new Expr.Constant(0), new Expr.Constant(5)).evaluate();
        expected = 0;
        assertEquals(expected, actual);

        actual = new Expr.Multiplication(new Expr.Constant(-1), new Expr.Constant(5)).evaluate();
        expected = -5;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("метод Exponent")
    void test5() {
        double actual = new Expr.Exponent(new Expr.Constant(5), 2).evaluate();
        double expected = 25;
        assertEquals(expected, actual);

        actual = new Expr.Exponent(new Expr.Constant(2), 0).evaluate();
        expected = 1;
        assertEquals(expected, actual);

        actual = new Expr.Exponent(new Expr.Constant(2), -1).evaluate();
        expected = 0.5;
        assertEquals(expected, actual);

        actual = new Expr.Exponent(new Expr.Constant(0), -1).evaluate();
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual);

        actual = new Expr.Exponent(new Expr.Constant(0), 5).evaluate();
        expected = 0;
        assertEquals(expected, actual);

        actual = new Expr.Exponent(new Expr.Constant(0), 0).evaluate();
        expected = 1;
        assertEquals(expected, actual);
    }
}

