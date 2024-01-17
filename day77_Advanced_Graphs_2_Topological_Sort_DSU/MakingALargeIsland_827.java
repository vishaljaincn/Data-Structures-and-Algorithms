package day77_Advanced_Graphs_2_Topological_Sort_DSU;

/*
You are given an n x n binary matrix grid. You are allowed to change at most one 0 to be 1.
Return the size of the largest island in grid after applying this operation.
An island is a 4-directionally connected group of 1s.

Example 1:

Input: grid = [[1,0],[0,1]]
Output: 3
Explanation: Change one 0 to 1 and connect two 1s, then we get an island with area = 3.
Example 2:

Input: grid = [[1,1],[1,0]]
Output: 4
Explanation: Change the 0 to 1 and make the island bigger, only one island with area = 4.
Example 3:

Input: grid = [[1,1],[1,1]]
Output: 4
Explanation: Can't change any 0 to 1, only one island with area = 4.
 */
/*
Time Complexity: O(N2)+O(N2) ~ O(N2) where N = total number of rows of the grid. Inside those nested loops, all
the operations are taking apparently constant time. So, O(N2) for the nested loop only, is the time complexity.

Space Complexity: O(2*N2) where N = the total number of rows of the grid. This is for the two arrays i.e. parent
array and size array of size N2 inside the Disjoint set.
 */

import java.util.HashSet;

// Class for the Disjoint Set data structure
class DisjointSet {
    int[] parent;
    int[] size;

    // Constructor to initialize DisjointSet with 'n' nodes
    public DisjointSet(int n) {
        parent = new int[n + 1];
        size = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;  // Each node is initially its own parent
            size[i] = 1;    // Each set has a size of 1 initially
        }
    }

    // Find the representative (root) of the set to which 'node' belongs with path compression
    public int findUPar(int node) {
        if (node == parent[node]) {
            return node;  // If the node is its own parent, it is the root of the set
        }
        return parent[node] = findUPar(parent[node]);  // Path compression for optimization
    }

    // Union by size to merge sets containing 'u' and 'v'
    public void unionBySize(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return;  // If both nodes are already in the same set, no need to merge
        if (size[ulp_u] < size[ulp_v]) {
            parent[ulp_u] = ulp_v;
            size[ulp_v] += size[ulp_u];
        } else {
            parent[ulp_v] = ulp_u;
            size[ulp_u] += size[ulp_v];
        }
    }
}

// Class for the solution to the problem
class MakingALargeIsland_827 {

    // Helper function to check if the given indices are within bounds
    private static boolean isValid(int newr, int newc, int n) {
        return newr >= 0 && newr < n && newc >= 0 && newc < n;
    }

    // Function to find the size of the largest group of connected 1s
    public static int MaxConnection(int grid[][]) {
        int n = grid.length;
        DisjointSetz ds = new DisjointSetz(n * n);  // Initialize DisjointSet

        // Step 1: Connect adjacent 1s using DisjointSet
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 0) continue;  // Skip 0s
                int dr[] = {-1, 0, 1, 0};
                int dc[] = {0, -1, 0, 1};
                for (int ind = 0; ind < 4; ind++) {
                    int newr = row + dr[ind];
                    int newc = col + dc[ind];
                    if (isValid(newr, newc, n) && grid[newr][newc] == 1) {
                        // Connect adjacent 1s using DisjointSet union operation
                        int nodeNo = row * n + col;
                        int adjNodeNo = newr * n + newc;
                        ds.unionBySize(nodeNo, adjNodeNo);
                    }
                }
            }
        }

        // Step 2: Calculate the size of the largest group of connected 1s
        int mx = Integer.MIN_VALUE; // Initialize mx to the smallest integer value
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 1) continue;  // Skip 1s
                int dr[] = {-1, 0, 1, 0};
                int dc[] = {0, -1, 0, 1};
                HashSet<Integer> components = new HashSet<>();
                for (int ind = 0; ind < 4; ind++) {
                    int newr = row + dr[ind];
                    int newc = col + dc[ind];
                    if (isValid(newr, newc, n)) {
                        if (grid[newr][newc] == 1) {
                            // Add parent of connected 1 to the HashSet
                            components.add(ds.findUPar(newr * n + newc));
                        }
                    }
                }
                int sizeTotal = 0;
                // Calculate the total size of connected components
                for (Integer parents : components) {
                    sizeTotal += ds.size[parents];
                }
                mx = Math.max(mx, sizeTotal + 1);  // Update the maximum size
            }
        }

        // Step 3: check if all the values in the given matrix are 1, then follow the below steps
        // Check if mx is still Integer.MIN_VALUE
        if (mx == Integer.MIN_VALUE) {
            // All cells are part of the islands, return the size of the matrix
            return n * n;
        } else {
            // Return the maximum size
            return mx;
        }

    }

    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 0, 1, 1, 0}, {1, 1, 0, 1, 1, 0},
                {1, 1, 0, 1, 1, 0}, {0, 0, 1, 0, 0, 0},
                {0, 0, 1, 1, 1, 0}, {0, 0, 1, 1, 1, 0}
        };

        int ans = MaxConnection(grid);
        System.out.println("The largest group of connected 1s is of size: " + ans);
    }
}
