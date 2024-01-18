package day78_Advanced_Graphs_3_MST_Dijkstra;
/*
Given a weighted, undirected, and connected graph of V vertices and an adjacency list adj where adj[i] is a list of
lists containing two integers where the first integer of each list j denotes there is an edge between i and j, second
integers corresponds to the weight of that edge. You are given the source vertex S and You have to Find the shortest
distance of all the vertex from the source vertex S. You have to return a list of integers denoting the shortest distance
between each node and the Source vertex S.
Note: The Graph does not contain any negative weight cycle.
Example 1:
Input:
V = 2
adj [] = {{{1, 9}}, {{0, 9}}}
S = 0
Output:
0 9
Explanation:
The source vertex is 0. Hence, the shortest distance of node 0 from the source is 0 and the shortest distance of node 1
from source will be 9.
 */
/*
Time Complexity: O( E log(V) ), Where E = Number of edges and V = Number of Nodes.

Space Complexity: O( |E| + |V| ), Where E = Number of edges and V = Number of Nodes.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

// Class representing a pair of vertex and its weight
class Pairs {
    int vertex;
    int weight;

    Pairs(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }
}

// Main solution class
public class Dijkstras_Algorithm_Shortest_Path_Priority_Queue {

    // Function to find the shortest distances from a source node
    public int[] solve(int A, int[][] B, int C) {

        // Adjacency list using ArrayList for flexibility
        ArrayList<ArrayList<Pairs>> adj = new ArrayList<>();
        for (int i = 0; i < A; i++) {
            adj.add(new ArrayList<>());
        }

        // Populate the adjacency list with edges and weights
        for (int i = 0; i < B.length; i++) {
            int u = B[i][0];
            int v = B[i][1];
            int w = B[i][2];
            adj.get(u).add(new Pairs(v, w));
            adj.get(v).add(new Pairs(u, w));
        }

        // Initialize distances array with maximum values
        int[] distances = new int[A];
        Arrays.fill(distances, Integer.MAX_VALUE);

        // Priority queue to store vertices with their distances
        PriorityQueue<Pairs> pq = new PriorityQueue<>((x, y) -> x.weight - y.weight);

        // Start from the source node C
        distances[C] = 0;
        pq.offer(new Pairs(C, 0));

        // Dijkstra's algorithm
        while (!pq.isEmpty()) {
            Pairs current = pq.poll();
            int currentNode = current.vertex;
            int currentDistance = current.weight;

            // Update distances for adjacent nodes
            for (Pairs neighbor : adj.get(currentNode)) {
                int nextNode = neighbor.vertex;
                int edgeWeight = neighbor.weight;
                int newDistance = currentDistance + edgeWeight;

                // If the new distance is shorter, update the distance and add to the priority queue
                if (newDistance < distances[nextNode]) {
                    distances[nextNode] = newDistance;
                    pq.offer(new Pairs(nextNode, newDistance));
                }
            }
        }

        // Convert any unreachable nodes to -1
        for (int i = 0; i < A; i++) {
            if (distances[i] == Integer.MAX_VALUE) {
                distances[i] = -1;
            }
        }

        // Return the array of distances
        return distances;
    }

    // Main method
    public static void main(String[] args) {
        // Example usage
        Dijkstras_Algorithm_Shortest_Path_Priority_Queue solution = new Dijkstras_Algorithm_Shortest_Path_Priority_Queue();
        int A = 5;
        int[][] B = {{0, 1, 2}, {0, 2, 4}, {1, 3, 3}, {2, 4, 1}, {3, 4, 5}};
        int C = 0;
        int[] result = solution.solve(A, B, C);

        // Print the result
        System.out.println(Arrays.toString(result));
    }
}
