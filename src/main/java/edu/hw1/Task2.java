package edu.hw1;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;

@SuppressWarnings("uncommentedmain") public class Task2 {
    private Task2() {

    }

    private final static org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger();

    public static int checkkoll(Integer number) {
        int koll = 0;
        Integer x = Math.abs(number);
        if (x.equals(0)) {
            ++koll;
        }
        final int del = 10;
        for (; x > 0; ++koll) {
            x /= del;
        }
        return koll;
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        Integer number = cin.nextInt();
        LOGGER.info(checkkoll(number));
        cin.close();
    }
}
