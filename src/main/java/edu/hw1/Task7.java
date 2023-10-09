package edu.hw1;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;

@SuppressWarnings("uncommentedmain")
public class Task7 {
    private Task7() {

    }

    private final static org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger();

    public static int rotateRight(int n, int shift) {
        int result = -1;
        if (n >= 0) {
            if (shift < 0) {
                result = rotateLeft(n, -shift);
            } else {
                String bin = Integer.toBinaryString(n);
                for (int i = 0; i < shift; ++i) {
                    bin = bin.charAt(bin.length() - 1) + bin.substring(0, bin.length() - 1);
                }
                result = Integer.parseInt(bin, 2);
            }
        }
        return result;
    }

    public static int rotateLeft(int n, int shift) {

        int result = -1;
        if (n >= 0) {
            if (shift < 0) {
                result = rotateRight(n, -shift);
            } else {
                String bin = Integer.toBinaryString(n);
                for (int i = 0; i < shift; ++i) {
                    bin = bin.substring(1, bin.length()) + bin.charAt(0);
                }
                result = Integer.parseInt(bin, 2);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        LOGGER.info("Input number: ");
        int n = cin.nextInt();
        LOGGER.info("Input shift: ");
        int shift = cin.nextInt();
        LOGGER.info(rotateLeft(n, shift));
        LOGGER.info(rotateRight(n, shift));
    }
}

