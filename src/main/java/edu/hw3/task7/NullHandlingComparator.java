package edu.hw3.task7;

import java.util.Comparator;

public class NullHandlingComparator<V extends Comparable<V>> implements Comparator<V> {

    @Override
    public int compare(V first, V second) {
        if (first == null && second == null) {
            return 0;
        } else if (first == null) {
            return -1;
        } else if (second == null) {
            return 1;
        }
        return first.compareTo(second);
    }
}
