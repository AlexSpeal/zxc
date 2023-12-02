package edu.hw3.Task5;

import java.util.ArrayList;
import java.util.Collections;

public class Task5 {
    private Task5() {

    }

    public static ArrayList<String> parseContacts(ArrayList<String> list, String compare) {
        if (list == null) {
            return new ArrayList<String>();
        }
        if (compare.equals("ASC")) {
            Collections.sort(list, new ASC());
        } else if (compare.equals("DESC")) {
            Collections.sort(list, new DESC());
        } else {
            throw new RuntimeException("Error");
        }
        return list;
    }
}
