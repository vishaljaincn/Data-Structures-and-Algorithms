package day76_Advanced_Graphs_1_DFS_BFS;
/*
Time Complexity: O(N + 2E) + O(N), Where N = Nodes, 2E is for total degrees as we traverse all adjacent nodes.
In the case of connected components of a graph, it will take another O(N) time.

Space Complexity: O(N) + O(N) ~ O(N), Space for recursive stack space and visited array.
 */

import java.util.ArrayList;

class DetectCycleInA_UnDirected_Graph_DFS_Not_Revised {
    private static boolean dfs(int node, int parent, int vis[], ArrayList<ArrayList<Integer>> adj) {
        vis[node] = 1;
        // go to all adjacent nodes
        for (int adjacentNode : adj.get(node)) {
            if (vis[adjacentNode] == 0) {
                if (dfs(adjacentNode, node, vis, adj) == true)
                    return true;
            }
            // if adjacent node is visited and is not its own parent node
            else if (adjacentNode != parent) return true;
        }
        return false;
    }

    // Function to detect cycle in an undirected graph.
    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        int vis[] = new int[V];
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                if (dfs(i, -1, vis, adj) == true) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);

        boolean ans = isCycle(4, adj);
        if (ans)
            System.out.println("1");
        else
            System.out.println("0");
    }

}
