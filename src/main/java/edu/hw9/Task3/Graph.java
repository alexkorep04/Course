package edu.hw9.Task3;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class Graph {
    private final int vertices;
    private final List<Integer>[] adjacencyList;

    public Graph(int vertices) {
        this.vertices = vertices;
        this.adjacencyList = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
    }

    public void addEdge(int from, int to) {
        adjacencyList[from].add(to);
    }

    @SuppressWarnings("MagicNumber")
    public Queue<Integer> parallelDFS(int startVertex) throws InterruptedException {
        Queue<Integer> queue = new LinkedBlockingDeque<>();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        AtomicBoolean found = new AtomicBoolean(false);
        List<Boolean> visited = new CopyOnWriteArrayList<>();
        for (int i = 0; i < vertices; i++) {
            visited.add(false);
        }
        dfs(startVertex, executorService, found, visited, queue);
        executorService.shutdown();
        return queue;
    }

    private void dfs(int currentVertex, ExecutorService executorService,
        AtomicBoolean found, List<Boolean> visited, Queue<Integer> queue) {
        queue.add(currentVertex);
        if (!found.get()) {
            visited.set(currentVertex, true);
            for (int neighbor : adjacencyList[currentVertex]) {
                if (!visited.get(neighbor)) {
                    executorService.execute(() -> dfs(neighbor, executorService, found, visited, queue));
                }
            }
        }
    }
}
