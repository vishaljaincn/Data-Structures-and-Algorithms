package day77_Advanced_Graphs_2_Topological_Sort_DSU;

/*
Time Complexity: O(V+E), where V = no. of nodes and E = no. of edges. This is a simple BFS algorithm.

Space Complexity: O(N) + O(N) ~ O(2N), O(N) for the indegree array, and O(N) for the queue data structure used in
BFS(where N = no.of nodes).
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class DetectCycleInA_Directed_Graph_Kahns_Algorithm {
    // Function to check if there exists a cycle in a directed graph using Kahn's algorithm.
    static boolean hasCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] indegree = new int[V];
        Queue<Integer> q = new LinkedList<>();

        // Calculate in-degrees for each vertex
        for (int i = 0; i < V; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }

        // Enqueue vertices with in-degree 0
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int processedNodes = 0;  // Counter to keep track of processed nodes

        while (!q.isEmpty()) {
            int node = q.poll();
            processedNodes++;

            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    q.add(it);
                }
            }
        }

        return processedNodes != V;  // If processedNodes is less than total nodes, there is a cycle
    }

    public static void main(String[] args) {
        // Number of vertices in the graph
        int V = 6;

        // Adjacency list representation of the graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Adding edges to the graph (creating a cycle intentionally)
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(0);
        adj.get(2).add(3);
        adj.get(3).add(4);
        adj.get(4).add(5);
        adj.get(5).add(3);

        // Check for the existence of a cycle using Kahn's algorithm
        boolean hasCycle = DetectCycleInA_Directed_Graph_Kahns_Algorithm.hasCycle(V, adj);

        if (hasCycle) {
            System.out.println("The graph contains a cycle.");
        } else {
            System.out.println("The graph does not contain a cycle.");
        }
    }
}
