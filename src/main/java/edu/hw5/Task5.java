package edu.hw5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task5 {
    private Task5() {

    }

    public static final Pattern carNumberPattern =
        Pattern.compile("^[АВЕКМНОРСТУХ]\\d{3}(?<!000)[АВЕКМНОРСТУХ]{2}\\d{2,3}$");

    public static boolean isCarNumber(String carNumber, Pattern carNumberPattern) {
        boolean result = false;
        if (carNumber != null) {
            Matcher matcher = carNumberPattern.matcher(carNumber);
            if (matcher.find()) {
                result = true;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.print(isCarNumber("А123ВЕ777", carNumberPattern));
    }
}
