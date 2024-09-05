package day78_Advanced_Graphs_3_MST_Dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
/*
Given a weighted, undirected, and connected graph of V vertices and an adjacency list adj where adj[i] is a list of lists
containing two integers where the first integer of each list j denotes there is an edge between i and j, and the second
integer corresponds to the weight of that edge. You are given two vertices A and B, and you have to find the shortest
distance between them using Dijkstra's algorithm. The graph does not contain any negative weight cycles.

Example 1:
Input:
V = 5
adj = {{{1, 2}, {2, 4}}, {{0, 2}, {3, 3}}, {{0, 4}, {4, 1}}, {{1, 3}, {4, 5}}, {{2, 1}, {3, 5}}}
A = 0
B = 4
Output:
Shortest distance from node 0 to node 4 is 5
*/

// Class representing a pair of vertex and its weight
class Pairss {
    int vertex;
    int weight;

    Pairss(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }
}

// Main solution class
public class Dijkstras_Algorithm_Shortest_Path_Priority_Queue_New_Variant {

    // Main method
    public static void main(String[] args) {
        // Example usage
        Dijkstras_Algorithm_Shortest_Path_Priority_Queue_New_Variant solution = new Dijkstras_Algorithm_Shortest_Path_Priority_Queue_New_Variant();
        int A = 5;
        int[][] B = {{0, 1, 2}, {0, 2, 4}, {1, 3, 3}, {2, 4, 1}, {3, 4, 5}};
        int startNode = 0;
        int endNode = 4;
        int shortestDistance = solution.findShortestDistance(A, B, startNode, endNode);

        // Print the shortest distance
        System.out.println("Shortest distance from node " + startNode + " to node " + endNode + " is: " + shortestDistance);
    }

    // Function to find the shortest distance between two nodes A and B
    public int findShortestDistance(int A, int[][] B, int startNode, int endNode) {

        // Adjacency list using ArrayList for flexibility
        ArrayList<ArrayList<Pairss>> adj = new ArrayList<>();
        for (int i = 0; i < A; i++) {
            adj.add(new ArrayList<>());
        }

        // Populate the adjacency list with edges and weights
        for (int i = 0; i < B.length; i++) {
            int u = B[i][0];
            int v = B[i][1];
            int w = B[i][2];
            adj.get(u).add(new Pairss(v, w));
            adj.get(v).add(new Pairss(u, w));
        }

        // Initialize distances array with maximum values
        int[] distances = new int[A];
        Arrays.fill(distances, Integer.MAX_VALUE);

        // Priority queue to store vertices with their distances
        PriorityQueue<Pairss> pq = new PriorityQueue<>((x, y) -> x.weight - y.weight);

        // Start from the startNode
        distances[startNode] = 0;
        pq.offer(new Pairss(startNode, 0));

        // Dijkstra's algorithm
        while (!pq.isEmpty()) {
            Pairss current = pq.poll();
            int currentNode = current.vertex;
            int currentDistance = current.weight;

            // If we reached the target node, return the distance
            if (currentNode == endNode) {
                return currentDistance;
            }

            // Update distances for adjacent nodes
            for (Pairss neighbor : adj.get(currentNode)) {
                int nextNode = neighbor.vertex;
                int edgeWeight = neighbor.weight;
                int newDistance = currentDistance + edgeWeight;

                // If the new distance is shorter, update the distance and add to the priority queue
                if (newDistance < distances[nextNode]) {
                    distances[nextNode] = newDistance;
                    pq.offer(new Pairss(nextNode, newDistance));
                }
            }
        }

        // If the endNode is unreachable, return -1
        return -1;
    }
}
