package edu.hw1;

import java.util.Scanner;
import java.util.Arrays;
import org.apache.logging.log4j.LogManager;

@SuppressWarnings("uncommentedmain")
public class Task6 {
    private Task6() {

    }

    private final static org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger();

    public static boolean proverka(Integer number) {
        boolean result = true;
        String str = Integer.toString(number);
        char[] num = str.toCharArray();

        for (int i = 0; i < num.length - 1; ++i) {
            if (num[i] != num[i + 1]) {
                result = false;
                break;
            }
        }
        return result;
    }

    public static int countK(int number) {
        if (number <= 1000 || number >= 9999 || proverka(number)) {
            return -1;
        }
        int result = 1;
        final int KAPR = 6174;
        final int tisacha = 1000;
        final int TEN = 10;
        int copx = number;
        final int n = 4;
        int[] mas = new int[n];
        for (int i = 0; i < n; ++i) {
            mas[i] = copx % TEN;
            copx = copx / TEN;

        }
        Arrays.sort(mas);
        int minnum = 0;
        int maxnum = 0;
        int mn2 = tisacha;
        int mn1 = 1;

        for (int i = 0; i < n; ++i) {
            minnum += mn2 * mas[i];
            maxnum += mn1 * mas[i];
            mn2 /= TEN;
            mn1 *= TEN;

        }
        Integer raznost = maxnum - minnum;
        if (!raznost.equals(KAPR)) {
            result += countK(raznost);
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        LOGGER.info("Input number: ");
        int number = cin.nextInt();
        LOGGER.info(countK(number));
    }
}
