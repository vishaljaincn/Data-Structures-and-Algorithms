package day80_Advanced_Graphs_4_Floyd_Warshall_And_Graph_Coloring;

/*
There is an undirected graph with n nodes, where each node is numbered between 0 and n - 1. You are given a 2D array
graph, where graph[u] is an array of nodes that node u is adjacent to. More formally, for each v in graph[u], there is
an undirected edge between node u and node v. The graph has the following properties:
There are no self-edges (graph[u] does not contain u).
There are no parallel edges (graph[u] does not contain duplicate values).
If v is in graph[u], then u is in graph[v] (the graph is undirected).
The graph may not be connected, meaning there may be two nodes u and v such that there is no path between them.
A graph is bipartite if the nodes can be partitioned into two independent sets A and B such that every edge in the graph
connects a node in set A and a node in set B.
Return true if and only if it is bipartite.

Example 1:
Input: graph = [[1,2,3],[0,2],[0,1,3],[0,2]]
Output: false
Explanation: There is no way to partition the nodes into two independent sets such that every edge connects a node in
one and a node in the other.

Example 2:
Input: graph = [[1,3],[0,2],[1,3],[0,2]]
Output: true
Explanation: We can partition the nodes into two sets: {0, 2} and {1, 3}.
 */
/*
Time Complexity: O(V + 2E), Where V = Vertices, 2E is for total degrees as we traverse all adjacent nodes.

Space Complexity: O(3V) ~ O(V), Space for queue data structure, colour array and an adjacency list.
*/

import java.util.ArrayList;
import java.util.Arrays;

class IsGraphBipartite_DFS_785_Not_Revised {
    // Function to check if a graph is bipartite using DFS
    public static boolean isBipartite(int[][] graph) {
        int V = graph.length;

        // Build adjacency list
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());

            // Populate adjacency list with neighbors
            for (int neighbor : graph[i]) {
                adjList.get(i).add(neighbor);
            }
        }

        // Array to store colors of nodes (-1: uncolored, 0: color A, 1: color B)
        int[] color = new int[V];
        Arrays.fill(color, -1);

        // Traverse each node and check if its connected component is bipartite
        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                // Check if the connected component is bipartite using DFS
                if (dfs(i, adjList, color, 0) == false) {
                    return false;
                }
            }
        }
        return true;
    }

    // Helper function to perform DFS and check bipartiteness
    private static boolean dfs(int node, ArrayList<ArrayList<Integer>> adjList, int[] color, int currentColor) {
        // Assign the current color to the current node
        color[node] = currentColor;

        // Explore neighbors
        for (int neighbor : adjList.get(node)) {
            // If the adjacent node is already colored with the same color, it's not bipartite
            if (color[neighbor] == currentColor) {
                return false;
            }

            // If the adjacent node is uncolored, recursively check with the opposite color
            if (color[neighbor] == -1 && dfs(neighbor, adjList, color, 1 - currentColor) == false) {
                return false;
            }
        }
        return true;
    }

    // Main method for testing
    public static void main(String[] args) {


        // Example usage
        int[][] graph = {{1, 3}, {0, 2}, {1, 3}, {0, 2}};
        boolean isBipartite = isBipartite(graph);

        System.out.println("Is the graph bipartite? " + isBipartite);
    }
}
