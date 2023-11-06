package edu.hw5;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class Task1 {
    private Task1() {

    }
private static final String baseTime= """
    2022-03-12, 20:20 - 2022-03-12, 23:50
    2022-04-01, 21:30 - 2022-04-02, 01:20
    """;

    private static final Pattern datePatten=Pattern.compile("\\d{4}-\\d{2}-\\d{2}, \\d{2}:\\d{2}");
    private static List<Map<String,Object>> parseString(String baseTime){


        return null;
    }
    public static void main(String[] args) {
        //System.out.print(durationTime());
    }
}
