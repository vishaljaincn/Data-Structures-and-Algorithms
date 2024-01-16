package day77_Advanced_Graphs_2_Topological_Sort_DSU;

/*
Time Complexity:  The actual time complexity is O(4) which is very small and close to 1. So, we can consider 4 as a constant.
 */
// DisjointSet class for Union-Find operations
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

    public static void main(String[] args) {
        Disjoint_Set_Union_By_Size ds = new Disjoint_Set_Union_By_Size(7);

        // Perform Union-Find operations
        ds.unionBySize(1, 2);
        ds.unionBySize(2, 3);
        ds.unionBySize(4, 5);
        ds.unionBySize(6, 7);
        ds.unionBySize(5, 6);

        // Check if elements 3 and 7 are in the same set
        if (ds.findUPar(3) == ds.findUPar(7)) {
            System.out.println("3 and 7 are in the same set.");
        } else {
            System.out.println("3 and 7 are in different sets.");
        }

        // Perform another Union-Find operation
        ds.unionBySize(3, 7);

        // Check if elements 3 and 7 are in the same set after the union
        if (ds.findUPar(3) == ds.findUPar(7)) {
            System.out.println("3 and 7 are in the same set after union.");
        } else {
            System.out.println("3 and 7 are in different sets after union.");
        }
    }
}
