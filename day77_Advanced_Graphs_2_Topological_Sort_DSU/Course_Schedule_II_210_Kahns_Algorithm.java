package day77_Advanced_Graphs_2_Topological_Sort_DSU;
/*
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array
prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of
them. If it is impossible to finish all courses, return an empty array.

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct
course order is [0,1].
Example 2:

Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
Output: [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2.
Both courses 1 and 2 should be taken after you finished course 0.
So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
Example 3:

Input: numCourses = 1, prerequisites = []
Output: [0]
 */
/*
Time Complexity: O(V+E), where V = no. of nodes and E = no. of edges. This is a simple BFS algorithm.

Space Complexity: O(N) + O(N) ~ O(2N), O(N) for the indegree array, and O(N) for the queue data structure used in
BFS(where N = no.of nodes).
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Course_Schedule_II_210_Kahns_Algorithm {
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
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

        // Use Kahn's algorithm for topological sorting
        int[] result = new int[numCourses];
        int[] indegree = new int[numCourses];
        int index = 0;

        // Calculate in-degrees for each vertex
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

        // Perform BFS until the queue is empty
        while (!q.isEmpty()) {
            // Dequeue a vertex with in-degree 0
            int node = q.poll();
            result[index++] = node;

            // Update in-degrees of adjacent vertices and enqueue them if in-degree becomes 0
            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    q.add(it);
                }
            }
        }

        // Check if all courses can be taken (no cycles in the graph)
        if (index == numCourses) {
            return result;
        } else {
            // If it is impossible to finish all courses, return an empty array
            return new int[0];
        }
    }

    public static void main(String[] args) {
        Course_Schedule_II_210_Kahns_Algorithm solution = new Course_Schedule_II_210_Kahns_Algorithm();

        // Example usage:
        int numCourses = 4;
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        int[] result = Course_Schedule_II_210_Kahns_Algorithm.findOrder(numCourses, prerequisites);

        // Print the result
        for (int course : result) {
            System.out.print(course + " ");
        }
    }
}
