package edu.hw1;

import java.util.Arrays;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;

@SuppressWarnings("uncommentedmain")
public class Task3 {
    private Task3() {

    }

    private final static org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger();

    public static Boolean isNestable(int[] mas1, int[] mas2) {
        boolean result = false;
        if (!(mas1.length == 0 || mas2.length == 0)) {
            int min1 = Arrays.stream(mas1).min().getAsInt();
            int min2 = Arrays.stream(mas2).min().getAsInt();
            int max1 = Arrays.stream(mas1).max().getAsInt();
            int max2 = Arrays.stream(mas2).max().getAsInt();
            if (min1 > min2 && max1 < max2) {
                result = true;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        LOGGER.info("Input a lenght mas1: ");
        int len1 = cin.nextInt();
        int[] mas1 = new int[len1];
        for (int i = 0; i < len1; ++i) {
            mas1[i] = cin.nextInt();
        }
        LOGGER.info("Input a lenght mas2: ");
        int len2 = cin.nextInt();
        int[] mas2 = new int[len2];
        for (int i = 0; i < len2; ++i) {
            mas2[i] = cin.nextInt();
        }
        LOGGER.info(isNestable(mas1, mas2));
        cin.close();
    }
}
