package edu.hw1;

import java.util.Scanner;

@SuppressWarnings("uncommentedmain")
public class Task1 {
    private Task1() {

    }

    public static Boolean check(String str) {
        boolean result = true;
        boolean flag = false;
        int length = str.length();
        String checkmin = str.substring(str.indexOf(':') + 1, length);
        String checksec = str.substring(0, str.indexOf(':'));
        if (checksec.length() < 2 || checkmin.length() != 2) {
            result = false;
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
            final int chifra = 60;
            if (seconds <= chifra && seconds >= 0 && minut >= 0) {
                result = minut * chifra + seconds;
            } else {
                result = -1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        System.out.print("Input a time: ");
        String time = cin.nextLine();
        System.out.print(minuteToSeconds(time));
        cin.close();
    }
}
