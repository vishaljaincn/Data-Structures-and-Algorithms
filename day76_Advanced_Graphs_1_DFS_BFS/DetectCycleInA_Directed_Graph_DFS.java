package day76_Advanced_Graphs_1_DFS_BFS;

import java.util.ArrayList;
/*
Time Complexity: O(V+E)+O(V) , where V = no. of nodes and E = no. of edges. There can be at most V components. So,
another O(V) time complexity.

Space Complexity: O(2N) + O(N) ~ O(2N): O(2N) for two visited arrays and O(N) for recursive stack space.
 */
class DetectCycleInA_Directed_Graph_DFS {

    // Helper function to perform DFS and check for cycles
    private boolean dfsCheck(int node, ArrayList<ArrayList<Integer>> adj, int vis[], int pathVis[]) {
        vis[node] = 1;         // Mark the node as visited
        pathVis[node] = 1;     // Mark the node as visited on the current path

        // Traverse adjacent nodes
        for (int it : adj.get(node)) {
            // When the node is not visited
            if (vis[it] == 0) {
                if (dfsCheck(it, adj, vis, pathVis)) return true;  // Recursive call for unvisited node
            }
            // If the node has been previously visited on the same path
            else if (pathVis[it] == 1) {
                return true;  // Cycle detected
            }
        }

        pathVis[node] = 0;  // Mark the node as not visited on the current path during backtracking
        return false;       // No cycle detected in this branch
    }

    // Function to detect cycle in a directed graph using DFS
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int vis[] = new int[V];         // Array to track visited nodes
        int pathVis[] = new int[V];     // Array to track visited nodes on the current path

        // Iterate through all nodes in the graph
        for (int i = 0; i < V; i++) {
            // If the current node has not been visited, perform DFS traversal
            if (vis[i] == 0) {
                if (dfsCheck(i, adj, vis, pathVis)) return true;  // If cycle is found, return true
            }
        }
        return false;  // No cycle found in the entire graph
    }

    public static void main(String[] args) {
        int V = 11;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(4);
        adj.get(3).add(7);
        adj.get(4).add(5);
        adj.get(5).add(6);
        adj.get(7).add(5);
        adj.get(8).add(9);
        adj.get(9).add(10);
        adj.get(10).add(8);

        DetectCycleInA_Directed_Graph_DFS obj = new DetectCycleInA_Directed_Graph_DFS();
        boolean ans = obj.isCyclic(V, adj);
        if (ans) System.out.println("True");    // If cycle is found, print True
        else System.out.println("False");        // If no cycle is found, print False
    }
}
