package edu.hw5;

import java.util.regex.Pattern;

public class Task8 {
    private Task8() {

    }

    //нечетной длины
    public static final Pattern stringPattern1 =
        Pattern.compile("^[01]([01]{2})*$");
    //начинается с 0 и имеет нечетную длину, или начинается с 1 и имеет четную длину
    public static final Pattern stringPattern2 =
        Pattern.compile("(^0([01]{2})*$)|(^(?=1)([01]{2})+$)");
    //любая строка, кроме 11 или 111
    public static final Pattern stringPattern4 =
        Pattern.compile("(^(1{2}|1{3})[01]{2,}$)|(^0[01]*$)|(^1$)|(^$)");

    //каждый нечетный символ равен 1
    public static final Pattern stringPattern5 =
        Pattern.compile("^(1([01]{0,1}))+$");

    //нет последовательных 1
    public static final Pattern stringPattern6 =
        Pattern.compile("^(?![01]*1{2})[01]*$");
}
