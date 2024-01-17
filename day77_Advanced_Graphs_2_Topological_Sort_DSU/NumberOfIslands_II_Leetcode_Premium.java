package day77_Advanced_Graphs_2_Topological_Sort_DSU;
/*
Problem Statement: You are given an n, m which means the row and column of the 2D matrix, and an array of size k
denoting the number of operations. Matrix elements are 0 if there is water or 1 if there is land. Originally,
the 2D matrix is all 0 which means there is no land in the matrix. The array has k operator(s) and each operator
has two integers A[i][0], A[i][1] means that you can change the cell matrix[A[i][0]][A[i][1]] from sea to island.
Return how many islands are there in the matrix after each operation. You need to return an array of size k.

Note: An island means a group of 1s such that they share a common side.

Pre-requisite: Disjoint Set data structure

Example 1:
Input Format: n = 4 m = 5 k = 4 A = {{1,1},{0,1},{3,3},{3,4}}
Output: 1 1 2 2

Example 2:
Input Format: n = 4 m = 5 k = 12 A = {{0,0},{0,0},{1,1},{1,0},{0,1},{0,3},{1,3},{0,4}, {3,2}, {2,2},{1,2}, {0,2}}
Output: 1 1 2 1 1 2 2 2 3 3 1 1
 */
/*
Time Complexity: O(Q*4α) ~ O(Q) where Q = no. of queries. The term 4α is so small that it can be considered constant.

Space Complexity: O(Q) + O(N*M) + O(N*M), where Q = no. of queries, N = total no. of rows, M = total no. of columns.
The last two terms are for the parent and the size array used inside the Disjoint set data structure.
The first term is to store the answer
 */

import java.util.ArrayList;
import java.util.List;


// DisjointSet class for Union-Find operations
class Disjoint_Set_Union_By_Sizez {
    private int[] size;      // Array to store the size of each set
    private int[] parent;    // Array to store the parent of each element in the set

    // Constructor to initialize the DisjointSet
    public Disjoint_Set_Union_By_Sizez(int n) {
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
    public void unionBySize(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);

        // If both elements are already in the same set, do nothing
        if (ulp_u == ulp_v) {
            return;
        }

        // Union by size: Attach smaller size tree under the root of the larger size tree
        if (size[ulp_u] < size[ulp_v]) {
            parent[ulp_u] = ulp_v;
            size[ulp_v] += size[ulp_u];
        } else {
            parent[ulp_v] = ulp_u;
            size[ulp_u] += size[ulp_v];
        }
    }
}

class NumberOfIslands_II_Leetcode_Premium {

    // Helper function to check if the given indices are within bounds
    private static boolean isValid(int adjr, int adjc, int n, int m) {
        return adjr >= 0 && adjr < n && adjc >= 0 && adjc < m;
    }

    // Function to calculate the number of islands after each operation
    public static List<Integer> numOfIslands(int n, int m, int[][] operators) {
        Disjoint_Set_Union_By_Sizez ds = new Disjoint_Set_Union_By_Sizez(n * m); // Initialize DisjointSet
        int[][] vis = new int[n][m]; // Matrix to track visited cells
        int cnt = 0; // Counter for the number of islands
        List<Integer> ans = new ArrayList<>(); // List to store results
        int len = operators.length; // Number of operations

        for (int i = 0; i < len; i++) {
            int row = operators[i][0];
            int col = operators[i][1];

            if (vis[row][col] == 1) {
                ans.add(cnt); // If the cell is already visited, add the current count
                continue;
            }

            vis[row][col] = 1; // Mark the current cell as visited
            cnt++; // Increment the island count

            int dr[] = {-1, 0, 1, 0};
            int dc[] = {0, 1, 0, -1};

            for (int ind = 0; ind < 4; ind++) {
                int adjr = row + dr[ind];
                int adjc = col + dc[ind];

                if (isValid(adjr, adjc, n, m)) {
                    if (vis[adjr][adjc] == 1) {
                        int nodeNo = row * m + col;
                        int adjNodeNo = adjr * m + adjc;

                        // If the adjacent cells are part of different sets, merge them
                        if (ds.findUPar(nodeNo) != ds.findUPar(adjNodeNo)) {
                            cnt--;
                            ds.unionBySize(nodeNo, adjNodeNo);
                        }
                    }
                }
            }

            ans.add(cnt); // Add the current island count after each operation
        }

        return ans;
    }

    public static void main(String[] args) {
        int n = 4, m = 5;
        int[][] operators = {{0, 0}, {0, 0}, {1, 1}, {1, 0}, {0, 1},
                {0, 3}, {1, 3}, {0, 4}, {3, 2}, {2, 2}, {1, 2}, {0, 2}
        };

        List<Integer> ans = numOfIslands(n, m, operators);

        int sz = ans.size();
        for (int i = 0; i < sz; i++) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println("");
    }
}
