package edu.hw1;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;

public class Task4 {
    private Task4() {

    }

    private final static org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger();

    public static String fixString(String str) {
        char[] c = str.toCharArray();
        int length = str.length();
        char tmp;
        for (int i = 0; i < length - 1; i += 2) {
            tmp = c[i];
            c[i] = c[i + 1];
            c[i + 1] = tmp;

        }
        return new String(c);
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        LOGGER.info("Input string: ");
        String str = cin.nextLine();
        LOGGER.info(fixString(str));
    }
}
