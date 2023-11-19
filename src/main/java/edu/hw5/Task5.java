package edu.hw5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task5 {
    private Task5() {

    }

    public static final Pattern CAR_NUMBER_PATTERN =
        Pattern.compile("^[АВЕКМНОРСТУХ]\\d{3}(?<!000)[АВЕКМНОРСТУХ]{2}\\d{2,3}$");

    public static boolean isCarNumber(String carNumber) {
        boolean result = false;
        if (carNumber != null) {
            Matcher matcher = CAR_NUMBER_PATTERN.matcher(carNumber);
            if (matcher.find()) {
                result = true;
            }
        }
        return result;
    }
}
