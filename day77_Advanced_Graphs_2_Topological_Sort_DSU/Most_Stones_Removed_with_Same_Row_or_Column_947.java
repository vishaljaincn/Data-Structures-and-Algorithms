package day77_Advanced_Graphs_2_Topological_Sort_DSU;

/*
On a 2D plane, we place n stones at some integer coordinate points. Each coordinate point may have at most one stone.
A stone can be removed if it shares either the same row or the same column as another stone that has not been removed.
Given an array stones of length n where stones[i] = [xi, yi] represents the location of the ith stone, return the
largest possible number of stones that can be removed.

Example 1:

Input: stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]
Output: 5
Explanation: One way to remove 5 stones is as follows:
1. Remove stone [2,2] because it shares the same row as [2,1].
2. Remove stone [2,1] because it shares the same column as [0,1].
3. Remove stone [1,2] because it shares the same row as [1,0].
4. Remove stone [1,0] because it shares the same column as [0,0].
5. Remove stone [0,1] because it shares the same row as [0,0].
Stone [0,0] cannot be removed since it does not share a row/column with another stone still on the plane.
Example 2:

Input: stones = [[0,0],[0,2],[1,1],[2,0],[2,2]]
Output: 3
Explanation: One way to make 3 moves is as follows:
1. Remove stone [2,2] because it shares the same row as [2,0].
2. Remove stone [2,0] because it shares the same column as [0,0].
3. Remove stone [0,2] because it shares the same row as [0,0].
Stones [0,0] and [1,1] cannot be removed since they do not share a row/column with another stone still on the plane.
Example 3:

Input: stones = [[0,0]]
Output: 0
Explanation: [0,0] is the only stone on the plane, so you cannot remove it.
 */
/*
Time Complexity: O(N), where N = total no. of stones. Here we have just traversed the given stones array several times.
And inside those loops, every operation is apparently taking constant time. So, the time complexity is only the time
of traversal of the array.

Space Complexity: O(2* (max row index + max column index)) for the parent and size array inside the Disjoint Set data
structure.
 */
// Class for the Disjoint Set data structure
class DisjointSetz {
    int[] parent;
    int[] size;

    // Constructor to initialize DisjointSet with 'n' nodes
    public DisjointSetz(int n) {
        parent = new int[n + 1];
        size = new int[n + 1];

        // Initialize each node as its own parent and set size to 1
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    // Find the representative (root) of the set to which 'node' belongs with path compression
    public int findUPar(int node) {
        if (node == parent[node]) {
            return node;  // If the node is its own parent, it is the root of the set
        }

        // Path compression: Set the parent of 'node' to its root during traversal
        return parent[node] = findUPar(parent[node]);
    }

    // Union by size to merge sets containing 'u' and 'v'
    public void unionBySize(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);

        if (ulp_u == ulp_v) return;  // If both nodes are already in the same set, no need to merge

        // Union by size: Attach the smaller set to the root of the larger set
        if (size[ulp_u] < size[ulp_v]) {
            parent[ulp_u] = ulp_v;
            size[ulp_v] += size[ulp_u];
        } else {
            parent[ulp_v] = ulp_u;
            size[ulp_u] += size[ulp_v];
        }
    }
}

class Most_Stones_Removed_with_Same_Row_or_Column {
    // Function to remove stones and return the largest possible number of stones that can be removed
    int removeStones(int[][] stones) {
        int n = stones.length;
        int maxRow = 0;
        int maxCol = 0;

        // Find the maximum row and column indices among the stones
        for (int i = 0; i < n; i++) {
            maxRow = Math.max(maxRow, stones[i][0]);
            maxCol = Math.max(maxCol, stones[i][1]);
        }

        // Create a Disjoint Set with enough nodes to represent rows, columns, and additional offsets
        DisjointSetz ds = new DisjointSetz(maxRow + maxCol + 1);

        // Union stones based on their rows and columns
        for (int i = 0; i < n; i++) {
            int nodeRow = stones[i][0];
            int nodeCol = stones[i][1] + maxRow + 1; // Offset columns to avoid overlapping with rows
            ds.unionBySize(nodeRow, nodeCol);
        }

        int cnt = 0;

        // Count the number of connected components with size greater than 1
        for (int i = 0; i <= maxRow + maxCol + 1; ++i)
            if (ds.findUPar(i) == i && ds.size[i] > 1) cnt++;

        // Return the largest possible number of stones that can be removed
        // { N(Total No Of Stones) - NUMBER OF VALID CONNECTED COMPONENTS}
        return n - cnt;
    }
}
