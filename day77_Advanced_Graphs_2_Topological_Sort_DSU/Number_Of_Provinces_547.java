package day77_Advanced_Graphs_2_Topological_Sort_DSU;

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

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Number_Of_Provinces_547 {
    // BFS traversal function
    private static void bfs(int node, ArrayList<ArrayList<Integer>> adjList, int vis[]) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node); // Add the starting node to the queue
        vis[node] = 1; // Mark the current node as visited

        // Perform BFS traversal
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int neighbor : adjList.get(curr)) {
                if (vis[neighbor] == 0) {
                    queue.offer(neighbor); // Add unvisited neighbor to the queue
                    vis[neighbor] = 1; // Mark the neighbor as visited
                }
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length; // Number of cities
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>()); // Initialize adjacency list
        }

        // Convert adjacency matrix to list
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Self nodes are not considered
                if (isConnected[i][j] == 1 && i != j) {
                    adjList.get(i).add(j); // Add edges to the adjacency list
                }
            }
        }

        int[] vis = new int[n]; // Array to keep track of visited cities
        int cnt = 0; // Counter for the number of provinces

        // Traverse the cities and perform BFS
        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                cnt++; // Increment the province count for each new starting city
                bfs(i, adjList, vis); // Explore the connected cities using BFS
            }
        }

        return cnt; // Return the total number of provinces
    }
}
