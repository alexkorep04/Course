package edu.hw3;

import edu.hw3.task8.BackwardIterator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Test8Test {
    @Test
    @DisplayName("test backward iterator")
    void testBackwardIterator() {
        List<Integer> list = List.of(1, 2, 3);
        BackwardIterator<Integer> iterator = new BackwardIterator<>(list);

        List<Integer> expected = List.of(3, 2, 1);

        List<Integer> response = new ArrayList<>();
        response.add(iterator.next());
        response.add(iterator.next());
        response.add(iterator.next());

        assertThat(response).isEqualTo(expected);
    }
}
