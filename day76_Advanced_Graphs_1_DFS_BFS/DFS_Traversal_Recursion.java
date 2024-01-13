package day76_Advanced_Graphs_1_DFS_BFS;
/*
You are given a connected undirected graph. Perform a Depth First Traversal of the graph.
Note: Use the recursive approach to find the DFS traversal of the graph starting from the 0th vertex from left to right
according to the graph.
Example 1:

Input: V = 5 , adj = [[2,3,1] , [0], [0,4], [0], [2]]

Output: 0 2 4 3 1
Explanation:
0 is connected to 2, 3, 1.
1 is connected to 0.
2 is connected to 0 and 4.
3 is connected to 0.
4 is connected to 2.
so starting from 0, it will go to 2 then 4,
and then 3 and 1.
Thus dfs will be 0 2 4 3 1.
Example 2:

Input: V = 4, adj = [[1,3], [2,0], [1], [0]]

Output: 0 1 2 3
Explanation:
0 is connected to 1 , 3.
1 is connected to 0, 2.
2 is connected to 1.
3 is connected to 0.
so starting from 0, it will go to 1 then 2
then back to 0 then 0 to 3
thus dfs will be 0 1 2 3.
 */
/*
Time Complexity: For an undirected graph, O(N) + O(2E), For a directed graph, O(N) + O(E), Because for every node we are
calling the recursive function once, the time taken is O(N) and 2E is for total degrees as we traverse for all adjacent nodes.

Space Complexity: O(3N) ~ O(N), Space for dfs stack space, visited array and an adjacency list.
 */

import java.util.ArrayList;

class DFS_Traversal_Recursion {

    // Function to perform DFS traversal of the graph
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {

        // ArrayList to store the DFS traversal result
        ArrayList<Integer> dfs = new ArrayList<>();

        // Array to track visited nodes
        boolean vis[] = new boolean[V];

        // Iterate through all nodes in the graph
        for (int i = 0; i < V; i++) {
            // If the current node has not been visited, perform DFS traversal
            if (!vis[i]) {
                dfsRecursive(i, adj, vis, dfs);
            }
        }

        // Return the DFS traversal result
        return dfs;
    }

    // Recursive helper function for DFS traversal
    private void dfsRecursive(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis, ArrayList<Integer> dfs) {
        // Mark the current node as visited
        vis[node] = true;

        // Add the current node to the DFS result
        dfs.add(node);

        // Iterate through all adjacent vertices of the current node
        for (Integer it : adj.get(node)) {
            // If an adjacent vertex has not been visited, recursively call dfsRecursive
            if (!vis[it]) {
                dfsRecursive(it, adj, vis, dfs);
            }
        }
    }

    // Main method for testing the DFS traversal
    public static void main(String args[]) {

        // Creating the adjacency list for the graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(4);
        adj.get(4).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(1).add(3);
        adj.get(3).add(1);

        // Creating an instance of the DFS_Traversal_Recursion class
        DFS_Traversal_Recursion sl = new DFS_Traversal_Recursion();

        // Performing DFS traversal and storing the result in 'ans'
        ArrayList<Integer> ans = sl.dfsOfGraph(5, adj);

        // Printing the DFS traversal result
        int n = ans.size();
        for (int i = 0; i < n; i++) {
            System.out.print(ans.get(i) + " ");
        }
    }
}
