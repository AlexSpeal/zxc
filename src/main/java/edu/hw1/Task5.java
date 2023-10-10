package edu.hw1;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;

@SuppressWarnings("uncommentedmain")
public class Task5 {
    private Task5() {

    }

    private final static org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger();

    private static Boolean palindrome(char[] str) {
        boolean result = true;
        int len = str.length;
        for (int i = 0; i < len / 2; ++i) {
            if (str[i] != str[len - 1 - i]) {
                result = false;
                break;
            }
        }

        return result;
    }

    public static Boolean isPalindromeDescendant(Integer number) {

        boolean result = false;
        StringBuilder resultstr;
        char[] num;
        String str = Integer.toString(number);
        final int ten = 10;
        if (number >= ten) {

            resultstr = new StringBuilder();
            while (str.length() != 1 && !result) {
                num = str.toCharArray();
                if (!palindrome(num)) {
                    if (str.length() % 2 == 0) {
                        for (int i = 0; i < num.length; i += 2) {
                            resultstr.append(
                                Character.digit(num[i], ten) + Character.digit(num[i + 1], ten));

                        }
                        str = resultstr.toString();
                        resultstr = new StringBuilder();
                    } else {
                        return false;
                    }
                } else {
                    result = true;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        LOGGER.info("Input number: ");
        Integer number = cin.nextInt();
        LOGGER.info(isPalindromeDescendant(number));
    }
}
