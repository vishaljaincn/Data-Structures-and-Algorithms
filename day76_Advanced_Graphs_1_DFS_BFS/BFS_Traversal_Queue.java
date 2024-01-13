package day76_Advanced_Graphs_1_DFS_BFS;
/*
Given a directed graph. The task is to do Breadth First Traversal of this graph starting from 0.
Note: One can move from node u to node v only if there's an edge from u to v. Find the BFS traversal of the graph starting from the 0th vertex, from left to right according to the input graph. Also, you should only take nodes directly or indirectly connected from Node 0 in consideration.
Example 1:

Input:
V = 5, E = 4
adj = {{1,2,3},{},{4},{},{}}
Output:
0 1 2 3 4
Explanation:
0 is connected to 1 , 2 , 3.
2 is connected to 4.
so starting from 0, it will go to 1 then 2
then 3. After this 2 to 4, thus bfs will be
0 1 2 3 4
 */
/*
Time Complexity: O(N) + O(2E), Where N = Nodes, 2E is for total degrees as we traverse all adjacent nodes.

Space Complexity: O(3N) ~ O(N), Space for queue data structure visited array and an adjacency list
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class BFS_Traversal_Queue {

    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {

        // ArrayList to store the BFS traversal result
        ArrayList<Integer> bfs = new ArrayList<>();

        // Array to track visited nodes
        boolean vis[] = new boolean[V];

        // Queue for BFS traversal
        Queue<Integer> q = new LinkedList<>();

        // Iterate through all nodes in the graph and perform BFS traversal
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                bfsFromNode(i, adj, vis, q, bfs);
            }
        }

        // Return the BFS traversal result
        return bfs;
    }

    // Function to perform BFS traversal starting from a specific node
    private void bfsFromNode(int startNode, ArrayList<ArrayList<Integer>> adj, boolean[] vis, Queue<Integer> q, ArrayList<Integer> bfs) {
        q.add(startNode);
        vis[startNode] = true;

        while (!q.isEmpty()) {
            // Dequeue a node and add it to the BFS result
            Integer node = q.poll();
            bfs.add(node);

            // Iterate through all adjacent vertices of the dequeued vertex
            for (Integer it : adj.get(node)) {
                // If an adjacent vertex has not been visited, mark it visited and enqueue it
                if (!vis[it]) {
                    vis[it] = true;
                    q.add(it);
                }
            }
        }
    }

    // Main method for testing the BFS traversal
    public static void main(String args[]) {

        // Creating the adjacency list for the graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(4);
        adj.get(4).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(1).add(3);
        adj.get(3).add(1);

        // Creating an instance of the BFS_Traversal_Queue class
        BFS_Traversal_Queue sl = new BFS_Traversal_Queue();

        // Performing BFS traversal and storing the result in 'ans'
        ArrayList<Integer> ans = sl.bfsOfGraph(5, adj);

        // Printing the BFS traversal result
        int n = ans.size();
        for (int i = 0; i < n; i++) {
            System.out.print(ans.get(i) + " ");
        }
    }
}
