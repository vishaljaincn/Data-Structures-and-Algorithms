package day77_Advanced_Graphs_2_Topological_Sort_DSU;

/*
There are n computers numbered from 0 to n - 1 connected by ethernet cables connections forming a network where
connections[i] = [ai, bi] represents a connection between computers ai and bi. Any computer can reach any other computer
directly or indirectly through the network.
You are given an initial computer network connections. You can extract certain cables between two directly connected computers,
and place them between any pair of disconnected computers to make them directly connected.
Return the minimum number of times you need to do this in order to make all the computers connected. If it is not possible,
return -1.

Example 1:

Input: n = 4, connections = [[0,1],[0,2],[1,2]]
Output: 1
Explanation: Remove cable between computer 1 and 2 and place between computers 1 and 3.
Example 2:


Input: n = 6, connections = [[0,1],[0,2],[0,3],[1,2],[1,3]]
Output: 2
Example 3:

Input: n = 6, connections = [[0,1],[0,2],[0,3],[1,2]]
Output: -1
Explanation: There are not enough cables.

 */
/*
    Time Complexity: O(E*4α) + O(N*4α) where E = no. of edges and N = no. of nodes.
    - The first term is to calculate the number of extra edges.
    - The second term is to count the number of components.
    - 4α is for the disjoint set operation used, and this term is considered constant.

    Space Complexity: O(2N) where N = no. of nodes.
    - 2N for the two arrays (parent and size) of size N used inside the disjoint set.
*/

import java.util.*;

class Solution {
    public int makeConnected(int n, int[][] connections) {
        // If there are not enough connections to connect all nodes, return -1
        if (connections.length < n - 1) return -1;

        // Initialize adjacency list
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        // Populate adjacency list based on connections
        for (int[] connection : connections) {
            adjList.get(connection[0]).add(connection[1]);
            adjList.get(connection[1]).add(connection[0]);
        }

        // Initialize visited array
        boolean[] visited = new boolean[n];

        // Count the number of connected components
        int components = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(i, adjList, visited);
                components++;
            }
        }

        // Return the number of operations needed
        return components - 1; // Number of operations = Number of components - 1
    }

    // BFS traversal function
    private void bfs(int node, List<List<Integer>> adjList, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node); // Add the starting node to the queue
        visited[node] = true; // Mark the current node as visited

        // Perform BFS traversal
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int neighbor : adjList.get(curr)) {
                if (!visited[neighbor]) {
                    queue.offer(neighbor); // Add unvisited neighbor to the queue
                    visited[neighbor] = true; // Mark the neighbor as visited
                }
            }
        }
    }
}
