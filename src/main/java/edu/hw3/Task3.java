package edu.hw3;

import java.util.HashMap;
import java.util.List;

public class Task3 {
    private Task3() {
    }

    public static HashMap<String, Integer> freqDict(List<String> list) {
        HashMap<String, Integer> map = new HashMap<>();
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
