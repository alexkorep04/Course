package edu.hw3;

import java.util.TreeMap;
import edu.hw3.task7.NullHandlingComparator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task7Test {
    @Test
    @DisplayName("Test treemap with null handling comparator")
    void testTreeMapWithNullValues() {
        TreeMap<String, Integer> map = new TreeMap<>(new NullHandlingComparator());

        map.put(null, 1);

        boolean expected = true;

        boolean response = map.containsKey(null);

        assertThat(response).isEqualTo(expected);
    }
}
