package edu.hw9;

import edu.hw9.Task3.Graph;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Queue;
import static org.assertj.core.api.Assertions.*;

public class Task3Test {

    @Test
    @DisplayName("Test DFS")
    public void testDFS() throws InterruptedException {
        Graph graph = new Graph(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 5);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);

        Queue<Integer> response = graph.parallelDFS(0);

        List<Integer> expected = List.of(0, 1, 3, 5);

        List<Integer> resp = response.stream().sorted().toList();

        assertThat(expected).isEqualTo(resp);
    }
}
