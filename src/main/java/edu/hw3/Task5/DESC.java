package edu.hw3.Task5;

import java.util.Comparator;

public class DESC implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        String str1 = o1.toString();
        String str2 = o2.toString();
        str1 = str1.trim();
        String sep = "\\s+";
        str1 = str1.replaceAll(sep, " ");
        str2 = str2.trim();
        str2 = str2.replaceAll(sep, " ");
        if (str1.split(" ").length == 2) {
            str1 = str1.substring(str1.indexOf(' ') + 1);
        }
        if (str2.split(" ").length == 2) {
            str2 = str2.substring(str2.indexOf(' ') + 1);
        }
        return -str1.compareTo(str2);
    }
}
