package edu.hw5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task4 {
    private Task4() {

    }

    public static final Pattern passwordPattern = Pattern.compile("[~!@#$%^&*|]");

    public static boolean isPassword(String password, Pattern passwordPattern) {
        boolean result = false;
        if (password != null) {
            Matcher matcher = passwordPattern.matcher(password);
            if (matcher.find()) {
                result = true;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.print(isPassword("asdasdfasfafsdfs dsfsd", passwordPattern));
    }
}
