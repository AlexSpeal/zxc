package edu.hw7;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Task2 {

    private Task2() {

    }

    public static BigInteger factorial(int num) {
        if (num == 1 || num == 0) {
            return new BigInteger("1");
        } else if (num < 0) {
            throw new RuntimeException("Число не может быть отрицательным!");
        }
        List<BigInteger> list = new ArrayList<>();
        for (int i = 2; i <= num; ++i) {
            list.add(new BigInteger(String.valueOf(i)));
        }
        return list.parallelStream().reduce(new BigInteger("1"), BigInteger::multiply);
    }
}
