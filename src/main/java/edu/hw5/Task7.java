package edu.hw5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task7 {
    private Task7() {

    }

    //содержит не менее 3 символов, причем третий символ равен 0
    public static final Pattern stringPattern1 =
        Pattern.compile("^[01]{2}0[01]*$");

    //начинается и заканчивается одним и тем же символом
    public static final Pattern stringPattern2 =
        Pattern.compile("^(((1[01]*1)|1)|((0[01]*0)|0))$");

    //длина не менее 1 и не более 3
    public static final Pattern stringPattern3 =
        Pattern.compile("^[01]{1,3}$");

    public static boolean isValidString(String str, Pattern stringPattern) {
        boolean result = false;
        if (str != null) {
            Matcher matcher = stringPattern.matcher(str);
            if (matcher.find()) {
                result = true;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        //System.out.print(isCarNumber("А123ВЕ777", carNumberPattern));
    }
}
