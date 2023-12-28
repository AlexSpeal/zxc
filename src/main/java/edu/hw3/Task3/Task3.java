package edu.hw3.Task3;

import java.util.ArrayList;
import java.util.HashMap;

public class Task3 {
    private Task3() {
    }

    public static HashMap<Object, Integer> freqDict(ArrayList<Object> list) {
        HashMap<Object, Integer> map = new HashMap<>();
        String s;
        if (!list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                s = list.get(i) + ":";
                if (map.containsKey(s)) {
                    map.replace(s, map.get(s) + 1);
                } else {
                    map.put(s, 1);
                }
            }
        }
        return map;
    }

}
