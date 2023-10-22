package edu.hw1;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;

@SuppressWarnings("uncommentedmain")
public class Task2 {
    private Task2() {

    }

    final static int DEL = 10;
    private final static org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger();

    public static int countDigits(Integer number) {
        int koll = 0;
        Integer x = Math.abs(number);
        if (x.equals(0)) {
            ++koll;
        }

        for (; x > 0; ++koll) {
            x /= DEL;
        }
        return koll;
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        LOGGER.info("Input a number: ");
        Integer number = cin.nextInt();
        LOGGER.info(countDigits(number));
        cin.close();
    }
}
