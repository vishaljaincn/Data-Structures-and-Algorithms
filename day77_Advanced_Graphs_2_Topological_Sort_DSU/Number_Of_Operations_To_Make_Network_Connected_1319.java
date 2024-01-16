package day77_Advanced_Graphs_2_Topological_Sort_DSU;

/*
There are n computers numbered from 0 to n - 1 connected by ethernet cables connections forming a network where
connections[i] = [ai, bi] represents a connection between computers ai and bi. Any computer can reach any other computer
directly or indirectly through the network.
You are given an initial computer network connections. You can extract certain cables between two directly connected computers,
and place them between any pair of disconnected computers to make them directly connected.
Return the minimum number of times you need to do this in order to make all the computers connected. If it is not possible,
return -1.

Example 1:

Input: n = 4, connections = [[0,1],[0,2],[1,2]]
Output: 1
Explanation: Remove cable between computer 1 and 2 and place between computers 1 and 3.
Example 2:


Input: n = 6, connections = [[0,1],[0,2],[0,3],[1,2],[1,3]]
Output: 2
Example 3:

Input: n = 6, connections = [[0,1],[0,2],[0,3],[1,2]]
Output: -1
Explanation: There are not enough cables.

 */
/*
    Time Complexity: O(E*4α) + O(N*4α) where E = no. of edges and N = no. of nodes.
    - The first term is to calculate the number of extra edges.
    - The second term is to count the number of components.
    - 4α is for the disjoint set operation used, and this term is considered constant.

    Space Complexity: O(2N) where N = no. of nodes.
    - 2N for the two arrays (parent and size) of size N used inside the disjoint set.
*/

////THIS QUESTION CAN BE SOLVED USING A BASIC DFS OR BFS TRAVERSAL, WE JUST NEED TO FIND THE NO OF CONNECTED COMPONENTS,
////WE USED DISJOINT SET DATA STRUCTURE TO GET FAMILIAR WITH IT

class Disjoint_Set_Union_By_Sizes {
    private int[] size;      // Array to store the size of each set
    private int[] parent;    // Array to store the parent of each element in the set

    // Constructor to initialize the DisjointSet
    public Disjoint_Set_Union_By_Sizes(int n) {
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

        // Union by size: Attach the smaller size tree under the root of the larger size tree
        if (size[ulp_u] < size[ulp_v]) {
            parent[ulp_u] = ulp_v;
            size[ulp_v] += size[ulp_u];
        } else {
            parent[ulp_v] = ulp_u;
            size[ulp_u] += size[ulp_v];
        }
    }
}

class Solution {
    // Function to make connected components and determine the number of extra edges needed
    public int makeConnected(int n, int[][] connections) {
        // Edge case: If the number of nodes is strictly less than the required number of connections to form a network
        if (connections.length < n - 1) {
            return -1; // It's not possible to form a fully connected network with fewer connections
        }

        Disjoint_Set_Union_By_Sizes dsu = new Disjoint_Set_Union_By_Sizes(n);

        // Variable to keep track of the number of extra edges needed
        int extraEdges = 0;

        // Perform union for each connection
        for (int[] connection : connections) {
            int u = connection[0];
            int v = connection[1];

            // If the two nodes are already in the same set, it means an extra edge is needed
            if (dsu.findUPar(u) == dsu.findUPar(v)) {
                extraEdges++;
            } else {
                dsu.unionBySize(u, v);
            }
        }

        // Count the number of unique parents (representatives)
        int uniqueParents = 0;
        for (int i = 0; i < n; i++) {
            if (dsu.findUPar(i) == i) {
                uniqueParents++;
            }
        }

        // Calculate the minimum number of operations needed
        int ans = uniqueParents - 1;

        // If the extraEdges are greater than or equal to ans, return ans; otherwise, it's not possible
        // to form a fully connected network, so return -1
        if (extraEdges >= ans) {
            return ans;
        } else {
            return -1;
        }
    }
}

