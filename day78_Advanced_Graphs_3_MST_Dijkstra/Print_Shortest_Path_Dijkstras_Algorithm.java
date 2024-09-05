package day78_Advanced_Graphs_3_MST_Dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/*
You are given a weighted undirected graph having n+1 vertices numbered from 0 to n and m edges describing there are
edges between a to b with some weight, find the shortest path between the vertex 1 and the vertex n, and if the path
does not exist then return a list consisting of only -1.
 */
/*
Time Complexity: O( E log(V) ) { for Dijkstra’s Algorithm } + O(V) { for backtracking in order to find the parent for
each node } Where E = Number of edges and V = Number of Nodes.

Space Complexity: O( |E| + |V| ) { for priority queue and dist array } + O( |V| ) { for storing the final path }
Where E = Number of edges and V = Number of Nodes.
 */
// Class representing a pair of vertex and its weight
class Pairz {
    int vertex;
    int weight;

    Pairz(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }
}

// Main solution class
public class Print_Shortest_Path_Dijkstras_Algorithm {

    // Main method
    public static void main(String[] args) {
        // Example usage for shortest path from vertex 1 to vertex 5
        Print_Shortest_Path_Dijkstras_Algorithm solution = new Print_Shortest_Path_Dijkstras_Algorithm();
        int A = 5;
        int[][] B = {{1, 2, 2}, {2, 5, 5}, {2, 3, 4}, {1, 4, 1}, {4, 3, 3}, {3, 5, 1}};
        int source = 1; // Specify the source vertex
        int destination = 5; // Specify the destination vertex

        int[] result = solution.solve(A, B, source, destination);

        // Print the result
        System.out.println(Arrays.toString(result));
    }

    // Function to find the shortest distances from a source node
    public int[] solve(int A, int[][] B, int source, int destination) {

        // Adjacency list using ArrayList for flexibility
        ArrayList<ArrayList<Pairz>> adj = new ArrayList<>();
        for (int i = 0; i <= A; i++) {  // Fix: Change from i = 1 to i = 0
            adj.add(new ArrayList<>());
        }

        // Populate the adjacency list with edges and weights
        for (int i = 0; i < B.length; i++) {
            int u = B[i][0];
            int v = B[i][1];
            int w = B[i][2];
            adj.get(u).add(new Pairz(v, w));
            adj.get(v).add(new Pairz(u, w));
        }

        // Initialize distances array with maximum values
        int[] distances = new int[A + 1];
        Arrays.fill(distances, Integer.MAX_VALUE);

        // Priority queue to store vertices with their distances
        PriorityQueue<Pairz> pq = new PriorityQueue<>((x, y) -> x.weight - y.weight);

        // Parent array to store the parent of each vertex in the shortest path
        int[] parent = new int[A + 1];
        Arrays.fill(parent, -1);

        // Start from the source node
        distances[source] = 0;
        pq.offer(new Pairz(source, 0));

        // Dijkstra's algorithm
        while (!pq.isEmpty()) {
            Pairz current = pq.poll();
            int currentNode = current.vertex;
            int currentDistance = current.weight;

            // Update distances for adjacent nodes
            for (Pairz neighbor : adj.get(currentNode)) {
                int nextNode = neighbor.vertex;
                int edgeWeight = neighbor.weight;
                int newDistance = currentDistance + edgeWeight;

                // If the new distance is shorter, update the distance and add to the priority queue
                if (newDistance < distances[nextNode]) {
                    distances[nextNode] = newDistance;
                    parent[nextNode] = currentNode;
                    pq.offer(new Pairz(nextNode, newDistance));
                }
            }
        }

        // Return the shortest path as an array
        return constructShortestPath(parent, source, destination);
    }

    // Method to construct the shortest path from source to destination
    private int[] constructShortestPath(int[] parent, int source, int destination) {
        ArrayList<Integer> path = new ArrayList<>();
        int current = destination;
        while (current != -1) {
            path.add(current);
            current = parent[current];
        }

        // Reverse the path and convert to an array
        int[] result = new int[path.size()];
        for (int i = path.size() - 1, j = 0; i >= 0; i--, j++) {
            result[j] = path.get(i);
        }

        return result;
    }
}
