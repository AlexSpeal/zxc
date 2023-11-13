package edu.hw5;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task1 {
    private Task1() {

    }

    final static int SECOND_DATE = 5;
    final static int FIRST_DATE = 1;
    public static final Pattern DATA_PATTERN = Pattern.compile("^(\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[1-2]\\d|3[0-1]),"
        + " ([0-1]\\d|2[0-4]):[0-5]\\d) - (\\d{4}-(0[1-9]|1[0-2])"
        + "-(0[1-9]|[1-2]\\d|3[0-1]), ([0-1]\\d|2[0-4]):[0-5]\\d)$"); //2004-09-10

    public static Duration getDuration(List<String> baseTime) {
        SimpleDateFormat formatter = new SimpleDateFormat("y-MM-dd, HH:mm");
        int sessionCount = 0;
        int fullDuration = 0;
        if (baseTime.isEmpty()) {
            throw new RuntimeException("the passed values are empty");
        }
        for (String session : baseTime) {
            Matcher matcher = DATA_PATTERN.matcher(session);

            if (matcher.find()) {
                try {
                    Date first = formatter.parse(matcher.group(FIRST_DATE));
                    Date end = formatter.parse(matcher.group(SECOND_DATE));
                    fullDuration += (int) Duration.between(first.toInstant(), end.toInstant()).getSeconds();
                    ++sessionCount;
                } catch (ParseException e) {
                    throw new RuntimeException("Parse Exeption");
                }

            } else {
                throw new RuntimeException("Invalid data format");
            }
        }
        return Duration.ofSeconds((long) fullDuration / sessionCount);
    }
}
