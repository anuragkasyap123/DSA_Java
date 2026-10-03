package Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BFSGraphTraversal {
    public static List<Integer> bfs(List<List<Integer>> graph, int start) {
        if (graph == null) {
            throw new IllegalArgumentException("Graph must not be null");
        }
        if (start < 0 || start >= graph.size()) {
            throw new IllegalArgumentException("Start vertex is out of range");
        }

        boolean[] visited = new boolean[graph.size()];
        List<Integer> traversalOrder = new ArrayList<>();
        Queue<Integer> queue = new ArrayDeque<>();

        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int vertex = queue.remove();
            traversalOrder.add(vertex);

            if (graph.get(vertex) == null) {
                throw new IllegalArgumentException("Adjacency lists must not be null");
            }

            for (int neighbor : graph.get(vertex)) {
                if (neighbor < 0 || neighbor >= graph.size()) {
                    throw new IllegalArgumentException("Neighbor vertex is out of range");
                }
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }

        return traversalOrder;
    }

    private static void addUndirectedEdge(List<List<Integer>> graph, int first, int second) {
        graph.get(first).add(second);
        graph.get(second).add(first);
    }

    public static void main(String[] args) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int vertex = 0; vertex < 7; vertex++) {
            graph.add(new ArrayList<>());
        }

        addUndirectedEdge(graph, 0, 1);
        addUndirectedEdge(graph, 0, 2);
        addUndirectedEdge(graph, 1, 3);
        addUndirectedEdge(graph, 1, 4);
        addUndirectedEdge(graph, 2, 5);
        addUndirectedEdge(graph, 5, 6);
        addUndirectedEdge(graph, 4, 6);

        System.out.println("BFS traversal: " + bfs(graph, 0));
    }
}
