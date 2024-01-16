package day77_Advanced_Graphs_2_Topological_Sort_DSU;

import java.util.ArrayList;

/*
There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b,
and city b is connected directly with city c, then city a is connected indirectly with city c.
A province is a group of directly or indirectly connected cities and no other cities outside of the group.
You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly
connected, and isConnected[i][j] = 0 otherwise.
Return the total number of provinces.

Example 1:

Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
Output: 2
Example 2:

Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
Output: 3
 */
// Time complexity: O(V + E), where V is the number of cities (vertices) and E is the number of edges in the adjacency list.
// Space complexity: O(V), where V is the number of cities, for the visited array.
class Number_Of_Provinces_547 {
    // DFS traversal function
    private static void dfs(int node, ArrayList<ArrayList<Integer>> adjLs, int vis[]) {
        vis[node] = 1; // Mark the current node as visited
        for (Integer it : adjLs.get(node)) {
            if (vis[it] == 0) {
                dfs(it, adjLs, vis); // Recursive DFS for unvisited neighbors
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length; // Number of cities
        ArrayList<ArrayList<Integer>> adjLs = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < n; i++) {
            adjLs.add(new ArrayList<Integer>()); // Initialize adjacency list
        }

        // Convert adjacency matrix to list
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Self nodes are not considered
                if (isConnected[i][j] == 1 && i != j) {
                    adjLs.get(i).add(j); // Add edges to the adjacency list
                    adjLs.get(j).add(i); // Add reverse edges for undirected graph
                }
            }
        }

        int[] vis = new int[n]; // Array to keep track of visited cities
        int cnt = 0; // Counter for the number of provinces

        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                cnt++; // Increment the province count for each new starting city
                dfs(i, adjLs, vis); // Explore the connected cities using DFS
            }
        }

        return cnt; // Return the total number of provinces
    }
}
