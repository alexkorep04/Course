package edu.hw9;

import edu.hw9.Task3.ConcurrentDFS;
import edu.hw9.Task3.Graph;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

public class Task3Test {
    Graph graph;
    ConcurrentDFS concurrentDFS;
    @BeforeEach
    public void createObjects() {
        graph = new Graph(8);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(3, 4);
        graph.addEdge(5, 6);
        graph.addEdge(2, 7);
        concurrentDFS = new ConcurrentDFS(5);
    }

    @Test
    @DisplayName("Test DFS")
    public void testDFS() throws InterruptedException {
        concurrentDFS.runDFSAsync(graph, 0);

        List<Integer> expected = List.of(0, 1, 2, 3, 4, 5, 6, 7);

        Thread.sleep(100);
        List<Integer> response = concurrentDFS.getNodes();
        response = response.stream().sorted().toList();

        assertThat(expected).isEqualTo(response);
    }
}
