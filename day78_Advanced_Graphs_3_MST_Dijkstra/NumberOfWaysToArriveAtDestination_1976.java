package day78_Advanced_Graphs_3_MST_Dijkstra;
/*
You are in a city that consists of n intersections numbered from 0 to n - 1 with bi-directional roads between some
intersections. The inputs are generated such that you can reach any intersection from any other intersection and that
there is at most one road between any two intersections.

You are given an integer n and a 2D integer array roads where roads[i] = [ui, vi, timei] means that there is a road
between intersections ui and vi that takes timei minutes to travel. You want to know in how many ways you can travel
from intersection 0 to intersection n - 1 in the shortest amount of time.

Return the number of ways you can arrive at your destination in the shortest amount of time. Since the answer may be
large, return it modulo 109 + 7.

Example 1:
Input: n = 7, roads = [[0,6,7],[0,1,2],[1,2,3],[1,3,3],[6,3,3],[3,5,1],[6,5,1],[2,5,1],[0,4,5],[4,6,2]]
Output: 4
Explanation: The shortest amount of time it takes to go from intersection 0 to intersection 6 is 7 minutes.
The four ways to get there in 7 minutes are:
- 0 ➝ 6
- 0 ➝ 4 ➝ 6
- 0 ➝ 1 ➝ 2 ➝ 5 ➝ 6
- 0 ➝ 1 ➝ 3 ➝ 5 ➝ 6

Example 2:
Input: n = 2, roads = [[1,0,10]]
Output: 1
Explanation: There is only one way to go from intersection 0 to intersection 1, and it takes 10 minutes.
 */
/*
Time Complexity: O( E* log(V)) { As we are using simple Dijkstra’s algorithm here, the time complexity will be or the
order E*log(V)} Where E = Number of edges and V = No. of vertices.

Space Complexity :  O(N) { for dist array + ways array + approximate complexity for priority queue }
Where, N = Number of nodes.
 */

import java.util.ArrayList;
import java.util.PriorityQueue;

class NodeDistancePair {
    int node;
    int distance;

    public NodeDistancePair(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }
}

public class NumberOfWaysToArriveAtDestination_1976 {
    public int countPaths(int n, int[][] roads) {
        // Creating an adjacency list for the given graph.
        ArrayList<ArrayList<NodeDistancePair>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        int numberOfRoads = roads.length;
        for (int i = 0; i < numberOfRoads; i++) {
            adjacencyList.get(roads[i][0]).add(new NodeDistancePair(roads[i][1], roads[i][2]));
            adjacencyList.get(roads[i][1]).add(new NodeDistancePair(roads[i][0], roads[i][2]));
        }

        // Defining a priority queue (min heap).
        PriorityQueue<NodeDistancePair> priorityQueue = new PriorityQueue<>((x, y) -> x.node - y.node);

        // Initializing the dist array and the ways array
        // along with their first indices.
        int[] dist = new int[n];
        int[] ways = new int[n];
        for (int i = 0; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;
            ways[i] = 0;
        }
        dist[0] = 0;
        ways[0] = 1;
        priorityQueue.add(new NodeDistancePair(0, 0));

        // Define modulo value
        int modulo = (int) (1e9 + 7);

        // Iterate through the graph with the help of priority queue
        // just as we do in Dijkstra's Algorithm.
        while (!priorityQueue.isEmpty()) {
            int currentDistance = priorityQueue.peek().distance;
            int currentNode = priorityQueue.peek().node;
            priorityQueue.remove();

            for (NodeDistancePair neighbor : adjacencyList.get(currentNode)) {
                int adjacentNode = neighbor.node;
                int edgeWeight = neighbor.distance;

                // This ‘if’ condition signifies that this is the first
                // time we’re coming with this short distance, so we push
                // in PQ and keep the no. of ways the same.
                if (currentDistance + edgeWeight < dist[adjacentNode]) {
                    dist[adjacentNode] = currentDistance + edgeWeight;
                    priorityQueue.add(new NodeDistancePair(adjacentNode, currentDistance + edgeWeight));
                    ways[adjacentNode] = ways[currentNode];
                } else if (currentDistance + edgeWeight == dist[adjacentNode]) {
                    // If we again encounter a node with the same short distance
                    // as before, we simply increment the no. of ways.
                    ways[adjacentNode] = (ways[adjacentNode] + ways[currentNode]) % modulo;
                }
            }
        }
        // Finally, we return the no. of ways to reach
        // (n-1)th node modulo 10^9+7.
        return ways[n - 1] % modulo;
    }
}
