package edu.hw5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task4 {
    private Task4() {

    }

    public static final Pattern PASSWORD_PATTERN = Pattern.compile("[~!@#$%^&*|]");

    public static boolean isPassword(String password) {
        boolean result = false;
        if (password != null) {
            Matcher matcher = PASSWORD_PATTERN.matcher(password);
            if (matcher.find()) {
                result = true;
            }
        }
        return result;
    }
}
