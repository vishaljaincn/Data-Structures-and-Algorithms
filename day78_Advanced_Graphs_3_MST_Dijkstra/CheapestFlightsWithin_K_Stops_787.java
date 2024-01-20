package day78_Advanced_Graphs_3_MST_Dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
There are n cities connected by some number of flights. You are given an array flights where
flights[i] = [fromi, toi, pricei] indicates that there is a flight from city fromi to city toi with cost pricei.
You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops.
If there is no such route, return -1.

Example 1:
Input: n = 4, flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], src = 0, dst = 3, k = 1
Output: 70+0
Explanation:
The graph is shown above.
The optimal path with at most 1 stop from city 0 to 3 is marked in red and has cost 100 + 600 = 700.
Note that the path through cities [0,1,2,3] is cheaper but is invalid because it uses 2 stops.

Example 2:
Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 1
Output: 200
Explanation:
The graph is shown above.
The optimal path with at most 1 stop from city 0 to 2 is marked in red and has cost 100 + 100 = 200.

Example 3:
Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 0
Output: 500
Explanation:
The graph is shown above.
The optimal path with no stops from city 0 to 2 is marked in red and has cost 500.
 */
/*
Time Complexity: O( N ) { Additional log(N) of time eliminated here because we’re using a simple queue rather than a
priority queue which is usually used in Dijkstra’s Algorithm }.
Where N = Number of flights / Number of edges.

Space Complexity:  O( |E| + |V| ) { for the adjacency list, priority queue, and the dist array }.
Where E = Number of edges (flights.size()) and V = Number of Airports.
 */
class Paird {
    int destination;
    int cost;

    public Paird(int destination, int cost) {
        this.destination = destination;
        this.cost = cost;
    }
}

class Tuplet {
    int stops;
    int node;
    int totalCost;

    public Tuplet(int stops, int node, int totalCost) {
        this.stops = stops;
        this.node = node;
        this.totalCost = totalCost;
    }
}

class CheapestFlightsWithin_K_Stops_787 {
    public static int findCheapestPrice(int n, int flights[][], int src, int dst, int K) {

        // Create the adjacency list to depict airports and flights in
        // the form of a graph.
        ArrayList<ArrayList<Paird>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        int m = flights.length;
        for (int i = 0; i < m; i++) {
            adj.get(flights[i][0]).add(new Paird(flights[i][1], flights[i][2]));
        }

        // Create a queue which stores the node and their distances from the
        // source in the form of {stops, {node, totalCost}} with 'stops' indicating
        // the number of nodes between src and the current node.
        Queue<Tuplet> q = new LinkedList<>();

        q.add(new Tuplet(0, src, 0));

        // Distance array to store the updated distances from the source.
        int[] dist = new int[n];
        Arrays.fill(dist, (int) (1e9));
        dist[src] = 0;

        // Iterate through the graph using a queue like in Dijkstra's algorithm
        // popping out the element with min stops first.
        while (!q.isEmpty()) {
            Tuplet currentTuplet = q.poll();
            int stops = currentTuplet.stops;
            int node = currentTuplet.node;
            int cost = currentTuplet.totalCost;

            // We stop the process as soon as the limit for the stops reaches.
            if (stops > K)
                continue;

            for (Paird neighbor : adj.get(node)) {
                int adjNode = neighbor.destination;
                int edgeWeight = neighbor.cost;

                // We only update the queue if the new calculated distance is
                // less than the previous and the stops are also within limits.
                if (cost + edgeWeight < dist[adjNode] && stops <= K) {
                    dist[adjNode] = cost + edgeWeight;
                    q.add(new Tuplet(stops + 1, adjNode, cost + edgeWeight));
                }
            }
        }
        // If the destination node is unreachable return '-1'
        // else return the calculated distance from src to dst.
        if (dist[dst] == (int) (1e9))
            return -1;
        return dist[dst];
    }

    public static void main(String[] args) {

        int n = 4, src = 0, dst = 3, K = 1;
        int[][] flights = {{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};


        int ans = findCheapestPrice(n, flights, src, dst, K);

        System.out.print(ans);
        System.out.println();
    }
}
