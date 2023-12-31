package edu.hw1;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;

@SuppressWarnings("uncommentedmain")
public class Task1 {
    private Task1() {

    }

    final static int SECINMIN = 60;
    private final static org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger();

    private static Boolean check(String str) {
        boolean result = true;
        boolean flag = false;
        int length = str.length();
        Integer index = str.indexOf(':');
        if (index.equals(-1)) {
            result = false;
        } else {
            String checksec = str.substring(str.indexOf(':') + 1, length);
            String checkmin = str.substring(0, str.indexOf(':'));
            if (checksec.length() < 2 || checkmin.length() != 2) {
                result = false;
            }
        }

        for (int i = 0; i < length && result; ++i) {
            if ((str.charAt(i) == ':') & (!flag)) {
                flag = true;
            } else if ((str.charAt(i) < '0') || (str.charAt(i) > '9')) {
                result = false;
            }
        }
        return (result && flag && (str.charAt(0) != ':'));
    }

    public static int minuteToSeconds(String time) {
        int result;
        if (!check(time)) {
            result = -1;
        } else {
            int tocolon = time.indexOf(':');
            int minut = Integer.parseInt(time.substring(0, tocolon));
            int seconds = Integer.parseInt(time.substring(tocolon + 1));
            if (seconds < SECINMIN && seconds >= 0 && minut >= 0) {
                result = minut * SECINMIN + seconds;
            } else {
                result = -1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        LOGGER.info("Input a time: ");
        String time = cin.nextLine();
        LOGGER.info(minuteToSeconds(time));
        cin.close();
    }
}
