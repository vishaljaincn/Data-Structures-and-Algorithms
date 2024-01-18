package day78_Advanced_Graphs_3_MST_Dijkstra;
/*
Given a weighted, undirected, and connected graph of V vertices and E edges. The task is to find the sum of weights of
the edges of the Minimum Spanning Tree.
*/
/*
Time Complexity: O(N+E) + O(E * logE) + O(E*4α*2)   where N = no. of nodes and E = no. of edges. O(N+E) for extracting
edge information from the adjacency list. O(E logE) for sorting the array consists of the edge tuples. Finally, we are
using the disjoint set operations inside a loop. The loop will continue to E times. Inside that loop, there are two
disjoint set operations like findUPar() and UnionBySize() each taking 4 and so it will result in 4*2. That is why the
last term O(E*4*2) is added.

Space Complexity: O(N) + O(N) + O(E) where E = no. of edges and N = no. of nodes. O(E) space is taken by the array that
we are using to store the edge information. And in the disjoint set data structure, we are using two N-sized arrays i.e.
a parent and a size array (as we are using unionBySize() function otherwise, a rank array of the same size if
unionByRank() is used) which result in the first two terms O(N).
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// Disjoint Set Union implementation based on size
class Disjoint_Set_Union_By_Size {
    private int[] size;      // Array to store the size of each set
    private int[] parent;    // Array to store the parent of each element in the set

    // Constructor to initialize the DisjointSet
    public Disjoint_Set_Union_By_Size(int n) {
        size = new int[n + 1];   // Index 0 is not used, so the size is n + 1
        parent = new int[n + 1];

        // Initialize each element as a separate set with size 1
        for (int i = 0; i <= n; i++) {
            size[i] = 1;
            parent[i] = i;
        }
    }

    // Find the representative (root) of the set to which a particular element belongs
    public int findUPar(int node) {
        if (node == parent[node]) {
            return node;
        }
        // Path compression: Make every visited node point directly to the root
        return parent[node] = findUPar(parent[node]);
    }

    // Union of two sets by size
    public boolean unionBySize(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);

        // If both elements are already in the same set, do nothing
        if (ulp_u == ulp_v) {
            return false; // No union was performed
        }

        // Union by size: Attach smaller size tree under the root of the larger size tree
        if (size[ulp_u] < size[ulp_v]) {
            parent[ulp_u] = ulp_v;
            size[ulp_v] += size[ulp_u];
        } else {
            parent[ulp_v] = ulp_u;
            size[ulp_u] += size[ulp_v];
        }

        return true; // Union was performed
    }
}

// Custom object type to store the edge and weight information
class Pair {
    int u;
    int v;
    int weight;

    public Pair(int u, int v, int weight) {
        this.u = u;
        this.v = v;
        this.weight = weight;
    }
}

// Comparator for Pair class to compare based on weight
class PairComparator implements Comparator<Pair> {
    @Override
    public int compare(Pair o1, Pair o2) {
        return Integer.compare(o1.weight, o2.weight);
    }
}

// Solution class
class Kruskals_Algorithm_MST {
    // Method to solve the problem
    public int solve(int A, int[][] B) {
        long minCost = 0;
        long m = 1000000007;

        // Build edge list
        List<Pair> list = new ArrayList<>();
        for (int i = 0; i < B.length; i++) {
            int u = B[i][0];
            int v = B[i][1];
            int weight = B[i][2];
            list.add(new Pair(u, v, weight));
        }

        // Sort the edges by weight in ascending order using Comparator
        Collections.sort(list, new PairComparator());

        // Initialize disjoint set
        Disjoint_Set_Union_By_Size dsu = new Disjoint_Set_Union_By_Size(A);

        // Check for each edge if it can be considered in the minimum spanning tree
        for (Pair edge : list) {
            // Union method combines 2 different components at a given time
            if (dsu.unionBySize(edge.u, edge.v)) {
                // If edge is considered, add weight to cost
                minCost = ((minCost % m) + ((long) edge.weight % m)) % m;
            }
        }

        return (int) minCost;
    }

    public static void main(String[] args) {
        // Example usage of Kruskal's Algorithm for Minimum Spanning Tree

        // Number of vertices
        int vertices = 4;

        // Example graph represented by edges and their weights
        int[][] edges = {
                {1, 2, 1},
                {2, 3, 2},
                {3, 4, 3},
                {4, 1, 4},
                {1, 3, 5}
        };

        // Create an instance of the Kruskals_Algorithm_MST class
        Kruskals_Algorithm_MST kruskalsAlgorithm = new Kruskals_Algorithm_MST();

        // Call the solve method to find the minimum cost of the Minimum Spanning Tree
        int minimumCost = kruskalsAlgorithm.solve(vertices, edges);

        // Print the minimum cost
        System.out.println("Minimum Cost of the Minimum Spanning Tree: " + minimumCost);
    }
}
