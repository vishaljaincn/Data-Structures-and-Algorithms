package day76_Advanced_Graphs_1_DFS_BFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// Time complexity: O(V + E) where V is the number of vertices and E is the number of edges.
// Space complexity: O(V) where V is the number of vertices for the boolean array to track visited nodes.

class DetectCycleInA_UnDirected_Graph_BFS {
    // Function to check for cycle using BFS
    static boolean checkForCycle(ArrayList<ArrayList<Integer>> adj, int s, boolean vis[]) {
        Queue<Pairz> q = new LinkedList<>(); // BFS queue
        q.add(new Pairz(s, -1)); // Add the starting node with its parent set to -1
        vis[s] = true; // Mark the starting node as visited

        // Traverse until the queue is empty
        while (!q.isEmpty()) {
            // Retrieve the current node and its parent
            Pairz node = q.poll();
            int cur = node.first; // Current node
            int parent = node.second; // Parent node

            // Explore all the adjacent nodes of the current node
            for (Integer it : adj.get(cur)) {
                if (!vis[it]) { // If the adjacent node is not visited
                    q.add(new Pairz(it, cur)); // Add it to the queue along with its parent
                    vis[it] = true; // Mark it as visited
                } else if (parent != it) // If the adjacent node is visited and not its own parent
                    return true; // There's a cycle
            }
        }

        return false; // No cycle found
    }

    // Function to detect cycle in an undirected graph
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean vis[] = new boolean[V]; // Array to track visited nodes
        Arrays.fill(vis, false); // Initially mark all nodes as unvisited

        // Traverse through all nodes and check for cycles
        for (int i = 0; i < V; i++)
            if (!vis[i]) // If the node is not visited
                if (checkForCycle(adj, i, vis)) // Check for cycle starting from this node
                    return true; // If cycle found, return true

        return false; // If no cycle found, return false
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            adj.add(new ArrayList<>()); // Initialize adjacency list for each node
        }
        // Adding edges to the graph
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);

        DetectCycleInA_UnDirected_Graph_BFS obj = new DetectCycleInA_UnDirected_Graph_BFS();
        boolean ans = obj.isCycle(4, adj); // Check for cycle in the graph
        if (ans)
            System.out.println("1"); // If cycle found, print 1
        else
            System.out.println("0"); // If no cycle found, print 0
    }
}

// Class to represent a Pairz of integers
class Pairz {
    int first; // First element of the Pairz
    int second; // Second element of the Pairz

    // Constructor to initialize the Pairz
    public Pairz(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
