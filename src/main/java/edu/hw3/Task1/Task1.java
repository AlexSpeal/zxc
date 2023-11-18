package edu.hw3.Task1;

import java.util.HashMap;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;

@SuppressWarnings("uncommentedmain")
public class Task1 {
    private Task1() {
    }

    final static int LEFT_BORDER_UPPERCASE = 65;
    final static int RIGHT_BORDER_UPPERCASE = 90;
    final static int LEFT_BORDER_LOWERCASE = 97;
    final static int RIGHT_BORDER_LOWERCASE = 122;
    private final static org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger();

    private static HashMap<Character, Character> hashMap;

    private static void encoder() {
        hashMap = new HashMap<>();
        for (char first = 'a', last = 'z'; first <= 'm' && 'n' <= last; ++first, --last) {
            hashMap.put(first, last);
            hashMap.put(last, first);
        }
        for (char first = 'A', last = 'Z'; first <= 'M' && 'N' <= last; ++first, --last) {
            hashMap.put(first, last);
            hashMap.put(last, first);
        }
    }

    public static String atbash(String s) {
        encoder();
        String str = s;
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) >= LEFT_BORDER_UPPERCASE && s.charAt(i) <= RIGHT_BORDER_UPPERCASE)
                || (s.charAt(i) >= LEFT_BORDER_LOWERCASE && s.charAt(i) <= RIGHT_BORDER_LOWERCASE)) {
                str = str.substring(0, i) + hashMap.get(str.charAt(i)) + str.substring(i + 1);
            }
        }
        return str;
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        LOGGER.info("Input a string: ");
        String str = cin.nextLine();
        LOGGER.info(atbash(str));
        cin.close();
    }
}
