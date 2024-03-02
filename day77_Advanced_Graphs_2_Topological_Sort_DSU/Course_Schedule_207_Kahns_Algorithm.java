package day77_Advanced_Graphs_2_Topological_Sort_DSU;
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
/*
Time Complexity: O(V+E), where V = no. of nodes and E = no. of edges. This is a simple BFS algorithm.

Space Complexity: O(N) + O(N) ~ O(2N), O(N) for the indegree array, and O(N) for the queue data structure used in
BFS(where N = no.of nodes).
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Course_Schedule_207_Kahns_Algorithm {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        // Create an adjacency list to represent the graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        // Build the graph based on prerequisites
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prerequisiteCourse = prerequisite[1];
            adj.get(prerequisiteCourse).add(course);
        }

        // Calculate in-degrees for each vertex
        int[] indegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }
        // Queue to store vertices with in-degree 0
        Queue<Integer> q = new LinkedList<>();

        // Enqueue vertices with in-degree 0
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int coursesTaken = 0;

        // Perform BFS until the queue is empty
        while (!q.isEmpty()) {
            // Dequeue a vertex with in-degree 0
            int node = q.poll();
            coursesTaken++;

            // Update in-degrees of adjacent vertices and enqueue them if in-degree becomes 0
            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    q.add(it);
                }
            }
        }

        // Check if all courses can be taken
        return coursesTaken == numCourses;
    }

    public static void main(String[] args) {

        // Example usage:
        int numCourses = 4;
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        boolean canFinish = canFinish(numCourses, prerequisites);

        // Print the result
        System.out.println(canFinish);  // It should print "true"
    }
}
