package day80_Advanced_Graphs_4_Floyd_Warshall_And_Graph_Coloring;

/*
Problem Statement: The problem is to find the shortest distances between every pair of vertices in a given edge-weighted
directed graph. The graph is represented as an adjacency matrix of size n*n. Matrix[i][j] denotes the weight of the edge
from i to j. If Matrix[i][j]=-1, it means there is no edge from i to j.

Do it in place.
 */
/*
Time Complexity: O(V3), as we have three nested loops each running for V times, where V = no. of vertices.

Space Complexity: O(V2), where V = no. of vertices. This space complexity is due to storing the adjacency matrix of the
given graph.
 */
// Class to implement the Floyd-Warshall algorithm
class Floyd_Warshall_Algorithm {

    // Method to find the shortest distances between all pairs of vertices
    public static void shortest_distance(int[][] matrix) {
        int n = matrix.length;

        // Convert -1 to a large value (representing infinity) in the matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = (int) (1e9);
                }

                // Set the distance to itself as 0
                if (i == j) matrix[i][j] = 0;
            }
        }

        // Apply the Floyd-Warshall algorithm
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // Update the matrix with the minimum distance
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                }
            }
        }

        // Convert back the large value to -1 in case it represents infinity
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == (int) (1e9)) {
                    matrix[i][j] = -1;
                }
            }
        }
    }

    public static void main(String[] args) {
        int V = 4;
        int[][] matrix = new int[V][V];

        // Initialize the matrix with -1 values
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                matrix[i][j] = -1;
            }
        }

        // Assign specific weights between vertices
        matrix[0][1] = 2;
        matrix[1][0] = 1;
        matrix[1][2] = 3;
        matrix[3][0] = 3;
        matrix[3][1] = 5;
        matrix[3][2] = 4;


        shortest_distance(matrix);

        // Print the resulting matrix with shortest distances
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
