package edu.hw3.task3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequencyOfObjects {
    private FrequencyOfObjects() {
    }

    public static Map<Object, Integer> getFrequency(List<Object> objects) {
        Map<Object, Integer> dictionary = new HashMap<>();
        for (Object o: objects) {
            if (dictionary.containsKey(o)) {
                int num = dictionary.get(o);
                dictionary.put(o, num + 1);
            } else {
                dictionary.put(o, 1);
            }
        }
        return dictionary;
    }
}
