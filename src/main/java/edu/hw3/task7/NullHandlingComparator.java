package edu.hw3.task7;

import java.util.Comparator;
import java.util.TreeMap;

public class NullHandlingComparator implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        if (s1 == null && s2 == null) {
            return 0;
        } else if (s1 == null) {
            return -1;
        } else if (s2 == null) {
            return 1;
        }
        return s1.compareTo(s2);
    }
    public static void main(String[] args) {
        TreeMap<String, String> treeMap = new TreeMap<>(new NullHandlingComparator());
        treeMap.put("apple", "fruit");
        treeMap.put("banana", "fruit");
        treeMap.put(null, "unknown");
        treeMap.put("carrot", "vegetable");
        for (String key : treeMap.keySet()) {
            System.out.println("Key: " + key + ", Value: " + treeMap.get(key));
        }
    }
}
