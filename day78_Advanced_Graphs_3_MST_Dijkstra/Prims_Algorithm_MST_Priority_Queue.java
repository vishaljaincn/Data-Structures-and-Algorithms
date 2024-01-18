package day78_Advanced_Graphs_3_MST_Dijkstra;

import java.util.ArrayList;
import java.util.PriorityQueue;
/*
Problem Statement: Given a weighted, undirected, and connected graph of V vertices and E edges. The task is to find the
sum of weights of the edges of the Minimum Spanning Tree.
 */
/*
Time Complexity: O(E*logE) + O(E*logE)~ O(E*logE), where E = no. of given edges.
The maximum size of the priority queue can be E so after at most E iterations the priority queue will be empty and the loop
will end. Inside the loop, there is a pop operation that will take logE time. This will result in the first O(E*logE)
time complexity. Now, inside that loop, for every node, we need to traverse all its adjacent nodes where the number of nodes
can be at most E. If we find any node unvisited, we will perform a push operation and for that, we need a logE time complexity.
So this will result in the second O(E*logE).

Space Complexity: O(E) + O(V), where E = no. of edges and V = no. of vertices. O(E) occurs due to the size of the priority queue
and O(V) due to the visited array. If we wish to get the mst, we need an extra O(V-1) space to store the edges of the most.
 */
public class Prims_Algorithm_MST_Priority_Queue {

    // Class to represent a pair (node, distance) in the graph
    class Pair {
        int node;
        int distance;

        // Constructor to initialize a Pair
        public Pair(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    // Function to find the minimum spanning tree using Prim's algorithm
    public int solve(int A, int[][] B) {
        int[] visited = new int[A]; // Array to keep track of visited nodes
        int totalSum = 0; // Variable to store the total weight of the minimum spanning tree

        // Priority queue to maintain the minimum distance while exploring nodes
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((x, y) -> x.distance - y.distance);

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>(); // Adjacency list to represent the graph

        // Initialize the adjacency list
        for (int i = 0; i < A; i++) {
            adj.add(new ArrayList<>());
        }

        // Populate the adjacency list with edges and weights from the input matrix B
        for (int i = 0; i < B.length; i++) {
            int u = B[i][0];
            int v = B[i][1];
            int w = B[i][2];
            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w));
        }

        // Start with node 0
        minHeap.add(new Pair(0, 0));

        // Prim's algorithm loop
        while (!minHeap.isEmpty()) {
            int node = minHeap.peek().node;
            int weight = minHeap.peek().distance;
            minHeap.remove();

            // Skip if the node is already visited
            if (visited[node] == 1) continue;

            // Mark the node as visited
            visited[node] = 1;

            // Update the total weight of the minimum spanning tree
            totalSum = totalSum + weight;

            // Explore neighbors of the current node
            for (Pair cur : adj.get(node)) {
                // Add unvisited neighbors to the priority queue
                if (visited[cur.node] == 0) {
                    minHeap.add(new Pair(cur.node, cur.distance));
                }
            }
        }

        // Return the total weight of the minimum spanning tree
        return totalSum;
    }
}
/*
////////////TAKE U FORWARD WEBPAGE CONTENT BELOW/////////////
Approach:
In order to implement Prim’s algorithm, we will be requiring an array(visited array) and a priority queue that will
essentially represent a min-heap. We need another array(MST) as well if we wish to store the edge information of the
minimum spanning tree.

The algorithm steps are as follows:

Priority Queue(Min Heap): The priority queue will be storing the pairs (edge weight, node). We can start from any
given node. Here we are going to start from node 0 and so we will initialize the priority queue with (0, 0). If we
wish to store the mst of the graph, the priority queue should instead store the triplets
(edge weight, adjacent node, parent node) and in that case, we will initialize with (0, 0, -1).

Visited array: All the nodes will be initially marked as unvisited.

sum variable: It will be initialized with 0 and we wish that it will store the sum of the edge weights finally.

MST array(optional): If we wish to store the minimum spanning tree(MST) of the graph, we need this array. This will
store the edge information as a pair of starting and ending nodes of a particular edge.

We will first push edge weight 0, node value 0, and parent -1 as a triplet into the priority queue to start the algorithm.
Note: We can start from any node of our choice. Here we have chosen node 0.
Then the top-most element (element with minimum edge weight as it is the min-heap we are using) of the priority queue
is popped out.
After that, we will check whether the popped-out node is visited or not.
If the node is visited: We will continue to the next element of the priority queue.
If the node is not visited: We will mark the node visited in the visited array and add the edge weight to the sum
variable. If we wish to store the mst, we should insert the parent node and the current node into the mst array as a
pair in this step.
Now, we will iterate on all the unvisited adjacent nodes of the current node and will store each of their information
in the specified triplet format i.e. (edge weight, node value, and parent node) in the priority queue.
We will repeat steps 2, 3, and 4 using a loop until the priority queue becomes empty.
Finally, the sum variable should store the sum of all the edge weights of the minimum spanning tree.
Note: Points to remember if we do not wish to store the mst(minimum spanning tree) for the graph and are only concerned
about the sum of all the edge weights of the minimum spanning tree:

First of all, we will not use the triplet format instead, we will just use the pair in the format of
(edge weight, node value). Basically, we do not need the parent node.
In step 3, we need not store anything in the mst array and we need not even use the mst array in our whole algorithm
as well.
Intuition:
The intuition of this algorithm is the greedy technique used for every node. If we carefully observe, for every node,
we are greedily selecting its unvisited adjacent node with the minimum edge weight(as the priority queue here is a
min-heap and the topmost element is the node with the minimum edge weight). Doing so for every node, we can get the sum
of all the edge weights of the minimum spanning tree and the spanning tree itself(if we wish to) as well.
 */