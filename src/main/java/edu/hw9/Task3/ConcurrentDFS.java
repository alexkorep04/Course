package edu.hw9.Task3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentDFS {

    private final ExecutorService executorService;
    private List<Integer> nodes;

    public ConcurrentDFS(int numThreads) {
        this.executorService = Executors.newFixedThreadPool(numThreads);
        nodes = new ArrayList<>();
    }

    public CompletableFuture<Void> runDFSAsync(Graph graph, int startNode) {
        CompletableFuture<Void> future = new CompletableFuture<>();
        List<CompletableFuture<Void>> tasks = new ArrayList<>();
        for (int i = 0; i < graph.getNumNodes(); i++) {
            int finalI = i;
            tasks.add(CompletableFuture.runAsync(() -> executeDFS(graph, finalI), executorService));
        }
        CompletableFuture<Void> allOf = CompletableFuture.allOf(tasks.toArray(new CompletableFuture[0]));
        return future;
    }

    private void executeDFS(Graph graph, int node) {
        if (!graph.isVisited(node)) {
            graph.markVisited(node);
            nodes.add(node);
            for (int neighbor : graph.getNeighbors(node)) {
                executeDFS(graph, neighbor);
            }
        }
    }

    public List<Integer> getNodes() {
        return nodes;
    }
}

