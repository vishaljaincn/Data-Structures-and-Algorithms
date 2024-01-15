package day76_Advanced_Graphs_1_DFS_BFS;
/*
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it
is impossible.
 */
// Time Complexity: O(V + E), where V is the number of courses (nodes) and E is the number of prerequisites (edges)
// Space Complexity: O(V + E), for creating a graph(Adjacency list), and an additional V for recursive stack space

import java.util.ArrayList;
import java.util.List;

class Course_Schedule_207 {
    // Function to check if it's possible to finish all courses
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = prerequisites.length;

        // Step 1: Initialize graph and variables
        List<List<Integer>> graph = new ArrayList<>(numCourses); // Represents the graph using an adjacency list
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // Step 2: Construct the graph from prerequisites
        for (int i = 0; i < n; i++) {
            int course = prerequisites[i][0];
            int prerequisite = prerequisites[i][1];
            graph.get(course).add(prerequisite);
        }

        int visited[] = new int[numCourses];         // Array to track visited nodes
        int pathVisited[] = new int[numCourses];     // Array to track visited nodes on the current path

        // Step 3: Iterate through all nodes in the graph
        for (int i = 0; i < numCourses; i++) {
            // If the current node has not been visited, perform DFS traversal
            if (visited[i] == 0) {
                // Step 4: Perform DFS check for cycle detection
                if (dfsCheck(i, graph, visited, pathVisited)) return false;  // If cycle is found, return false
            }
        }
        return true;  // No cycle found in the entire graph, all courses can be finished
    }

    // Step 4: Define DFS traversal for cycle detection
    private boolean dfsCheck(int node, List<List<Integer>> adj, int visited[], int pathVisited[]) {
        visited[node] = 1;         // Mark the node as visited
        pathVisited[node] = 1;     // Mark the node as visited on the current path

        // Step 5: Traverse adjacent nodes
        for (int neighbor : adj.get(node)) {
            // When the node is not visited
            if (visited[neighbor] == 0) {
                // Recursive call for unvisited node
                if (dfsCheck(neighbor, adj, visited, pathVisited)) return true;  // If cycle is found, return true
            }
            // If the node has been previously visited on the same path
            else if (pathVisited[neighbor] == 1) {
                return true;  // Cycle detected
            }
        }

        pathVisited[node] = 0;  // Mark the node as not visited on the current path during backtracking
        return false;       // No cycle detected in this branch
    }
}
