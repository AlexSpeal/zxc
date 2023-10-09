package edu.hw1;

import org.apache.logging.log4j.LogManager;
import java.util.Scanner;

@SuppressWarnings("uncommentedmain")
public class Task5 {
    private Task5() {

    }

    private final static org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger();

    public static Boolean palindrome(char[] str) {
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
        if (number >= 10) {

            resultstr = new StringBuilder();
            while (str.length() != 1 && !result) {
                num = str.toCharArray();
                if (!palindrome(num)) {
                    if (str.length() % 2 == 0) {
                        for (int i = 0; i < num.length; i += 2) {
                            resultstr.append(Character.digit(num[i], 10) + Character.digit(num[i + 1], 10));

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
