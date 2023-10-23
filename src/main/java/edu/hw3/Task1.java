package edu.hw3;

import java.util.HashMap;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;

@SuppressWarnings("uncommentedmain")
public class Task1 {
    private Task1() {
    }

    final static int LEFTA = 65;
    final static int RIGHTA = 90;
    final static int LEFTB = 97;
    final static int RIGHTB = 122;
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
            if ((s.charAt(i) >= LEFTA && s.charAt(i) <= RIGHTA) || (s.charAt(i) >= LEFTB && s.charAt(i) <= RIGHTB)) {
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
