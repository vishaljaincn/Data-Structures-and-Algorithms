package day77_Advanced_Graphs_2_Topological_Sort_DSU;
/*
Time Complexity: O(V+E), where V = no. of nodes and E = no. of edges. This is a simple BFS algorithm.

Space Complexity: O(N) + O(N) ~ O(2N), O(N) for the indegree array, and O(N) for the queue data structure used in
BFS(where N = no.of nodes).
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Topological_Sort_Kahns_Algorithm_BFS {
    // Function to return list containing vertices in Topological order using Kahn's algorithm.
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        // Array to store the in-degree of each vertex
        int indegree[] = new int[V];

        // Calculate in-degrees for each vertex
        for (int i = 0; i < V; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }

        // Queue to store vertices with in-degree 0
        Queue<Integer> q = new LinkedList<Integer>();

        // Enqueue vertices with in-degree 0
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        // Array to store the topological order
        int topo[] = new int[V];
        int i = 0;

        // Perform BFS until the queue is empty
        while (!q.isEmpty()) {
            // Dequeue a vertex with in-degree 0
            int node = q.peek();
            q.remove();

            // Add the dequeued vertex to the topological order
            topo[i++] = node;

            // Update in-degrees of adjacent vertices and enqueue them if in-degree becomes 0
            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    q.add(it);
                }
            }
        }

        return topo;
    }

    public static void main(String[] args) {
        // Number of vertices in the graph
        int V = 6;

        // Adjacency list representation of the graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Adding edges to the graph
        adj.get(2).add(3);
        adj.get(3).add(1);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(5).add(0);
        adj.get(5).add(2);

        // Perform topological sort using Kahn's algorithm and print the result
        int[] ans = Topological_Sort_Kahns_Algorithm_BFS.topoSort(V, adj);
        for (int node : ans) {
            System.out.print(node + " ");
        }
        System.out.println("");
    }
}
