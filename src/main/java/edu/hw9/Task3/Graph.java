package edu.hw9.Task3;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private final int numNodes;
    private final List<List<Integer>> adjacencyList;
    private final boolean[] visited;

    public Graph(int numNodes) {
        this.numNodes = numNodes;
        this.adjacencyList = new ArrayList<>();
        this.visited = new boolean[numNodes];

        for (int i = 0; i < numNodes; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    public void addEdge(int from, int to) {
        adjacencyList.get(from).add(to);
        adjacencyList.get(to).add(from);
    }

    public Iterable<Integer> getNeighbors(int node) {
        return adjacencyList.get(node);
    }

    public boolean isVisited(int node) {
        return visited[node];
    }

    public void markVisited(int node) {
        visited[node] = true;
    }

    public int getNumNodes() {
        return numNodes;
    }
}
