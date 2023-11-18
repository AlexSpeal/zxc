package edu.hw3.Task4;

import java.util.LinkedHashMap;
import java.util.Map;

@SuppressWarnings("uncommentedmain")
public class Task4 {
    private Task4() {

    }

    final static int ONE = 1;
    final static int FOUR = 4;
    final static int FIVE = 5;
    final static int NINE = 9;
    final static int TEN = 10;
    final static int FOURTY = 40;
    final static int FIFTY = 50;
    final static int NINETY = 90;
    final static int HUNDRED = 100;
    final static int FOURHUNDRED = 400;
    final static int FIVEHUNDRED = 500;
    final static int NINEHUNDRED = 900;
    final static int THOUSAND = 1000;
    final static int BORDER = 3999;

    public static Map<Integer, String> dictionary() {
        Map<Integer, String> linkedHashMap = new LinkedHashMap<Integer, String>();
        linkedHashMap.put(THOUSAND, "M");
        linkedHashMap.put(NINEHUNDRED, "CM");
        linkedHashMap.put(FIVEHUNDRED, "D");
        linkedHashMap.put(FOURHUNDRED, "CD");
        linkedHashMap.put(HUNDRED, "C");
        linkedHashMap.put(NINETY, "XC");
        linkedHashMap.put(FIFTY, "L");
        linkedHashMap.put(FOURTY, "XL");
        linkedHashMap.put(TEN, "X");
        linkedHashMap.put(NINE, "IX");
        linkedHashMap.put(FIVE, "V");
        linkedHashMap.put(FOUR, "IV");
        linkedHashMap.put(ONE, "I");
        return linkedHashMap;
    }

    public static String convertToRoman(int number) throws Exception {
        Map<Integer, String> dictionary = dictionary();
        StringBuilder result = new StringBuilder();
        int num = number;
        int key;
        String grade;
        if (num == 0) {
            result.append("N");
        } else if (num < 0 || num > BORDER) {
            throw new RuntimeException("Error");
        } else {
            for (Map.Entry<Integer, String> entry : dictionary.entrySet()) {
                key = entry.getKey();
                grade = entry.getValue();
                while (num >= key) {
                    num -= key;
                    result.append(grade);
                }
            }
        }
        return result.toString();
    }
}
