package edu.hw3;

import java.util.ArrayList;
import java.util.Stack;
import org.apache.logging.log4j.LogManager;

@SuppressWarnings("uncommentedmain")
public class Task2 {
    private Task2() {

    }

    private final static org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger();

    public static String check(String str) {
        String str1 = str;
        boolean flag = true;
        char[] x = str.toCharArray();
        for (int i = 0; i < x.length; ++i) {
            if (x[i] != '(' && x[i] != ')') {
                flag = false;
            }
        }
        if (!flag) {
            str1 = "";
        }
        return str1;
    }

    public static ArrayList<String> cluster(String str) {

        ArrayList<String> result = new ArrayList<>();
        String res = "";
        String str2 = str;
        Stack<Character> stack = new Stack<>();
        boolean flag = true;
        for (int i = 0; i < str2.length() && flag; ++i) {
            if (str2.charAt(i) == '(') {
                stack.push(str2.charAt(i));
                res += str2.charAt(i);
            } else if (str2.charAt(i) == ')') {
                if (stack.empty() || stack.pop() != '(') {
                    flag = false;
                } else {
                    res += str2.charAt(i);
                }

            } else {
                flag = false;
            }
            if (stack.empty() && flag) {
                result.add(res);
                res = "";
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList<String> x = cluster("((())())(()(()()))");
        for (String s : x) {
            LOGGER.info(s);
        }
    }
}
