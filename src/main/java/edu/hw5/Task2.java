package edu.hw5;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task2 {
    private Task2() {

    }

    final static int FIRST_MONTH = 1;
    final static int THIRD_GROUP = 3;
    final static int THIRTEENTH_MONTH = 13;
    public static final Pattern DATA_PATTERN = Pattern.compile("^(0|[1-9]\\d*)-(0[1-9]|1[0-2])"
        + "-(0[1-9]|[1-2]\\d|3[0-1])$");

    public static List<LocalDate> getFridaysOnYear(int year) {
        List<LocalDate> result = new ArrayList<>();
        if (year >= 0) {
            LocalDate resultDate = LocalDate.of(year, FIRST_MONTH, THIRTEENTH_MONTH);
            while (resultDate.getYear() == year) {
                if (resultDate.getDayOfWeek() == DayOfWeek.FRIDAY) {
                    result.add(resultDate);
                }
                resultDate = resultDate.plusMonths(1);

            }
        } else {
            throw new RuntimeException();
        }
        return result;
    }

    public static LocalDate getNextFriday(String date) {
        Matcher matcher = DATA_PATTERN.matcher(date);
        if (matcher.find()) {
            int year = Integer.parseInt(matcher.group(1));
            int month = Integer.parseInt(matcher.group(2));
            int day = Integer.parseInt(matcher.group(THIRD_GROUP));
            LocalDate currentDate = LocalDate.of(year, month, day);
            List<LocalDate> listDate = getFridaysOnYear(year);
            TemporalAdjuster nextF = temporal -> {
                for (var i : listDate) {
                    if (i.isAfter(currentDate)) {
                        return i;
                    }
                }
                return null;
            };
            LocalDate result = currentDate.with(nextF);
            if (result == null) {
                result = getFridaysOnYear(++year).get(0);
            }
            return result;
        }
        return null;
    }
}
