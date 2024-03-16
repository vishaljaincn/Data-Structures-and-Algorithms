package day77_Advanced_Graphs_2_Topological_Sort_DSU;

/*
Time Complexity: O(V+E)+O(V), where V = no. of nodes and E = no. of edges. There can be at most V components. So,
another O(V) time complexity.

Space Complexity: O(2N) + O(N) ~ O(2N): O(2N) for the visited array and the stack carried during DFS calls and O(N) for
recursive stack space, where N = no. of nodes.
 */

import java.util.ArrayList;
import java.util.Stack;

class Topological_Sort_Algorithm_DFS_Not_Revised {

    // Function to perform Depth-First Search (DFS) for Topological Sorting
    private static void dfs(int node, int vis[], Stack<Integer> st, ArrayList<ArrayList<Integer>> adj) {
        // Mark the current node as visited
        vis[node] = 1;

        // Traverse all adjacent nodes that have not been visited yet
        for (int neighbor : adj.get(node)) {
            if (vis[neighbor] == 0)
                // Recursive call for unvisited neighbors
                dfs(neighbor, vis, st, adj);
        }

        // Push the current node to the stack after processing its neighbors
        st.push(node);
    }

    // Function to return list containing vertices in Topological order.
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        // Array to mark visited nodes during DFS
        int vis[] = new int[V];

        // Stack to store nodes in topological order
        Stack<Integer> st = new Stack<Integer>();

        // Perform DFS for each unvisited node in the graph
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                dfs(i, vis, st, adj);
            }
        }

        // Populate the result array with nodes in topological order
        int ans[] = new int[V];
        int i = 0;
        while (!st.isEmpty()) {
            ans[i++] = st.peek();
            st.pop();
        }

        return ans;
    }
}

