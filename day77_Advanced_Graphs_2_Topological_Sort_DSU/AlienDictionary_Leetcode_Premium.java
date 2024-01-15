package day77_Advanced_Graphs_2_Topological_Sort_DSU;
/*
Given a sorted dictionary of an alien language having N words and k starting alphabets of standard dictionary.
Find the order of characters in the alien language.
Note: Many orders may be possible for a particular test case, thus you may return any valid order and output will be 1
if the order of string returned by the function is correct else 0 denoting incorrect string returned.

Example 1:

Input:
N = 5, K = 4
dict = {"baa","abcd","abca","cab","cad"}
Output:
1
Explanation:
Here order of characters is
'b', 'd', 'a', 'c' Note that words are sorted
and in the given language "baa" comes before
"abcd", therefore 'b' is before 'a' in output.
Similarly we can find other orders.
Example 2:

Input:
N = 3, K = 3
dict = {"caa","aaa","aab"}
Output:
1
Explanation:
Here order of characters is
'c', 'a', 'b' Note that words are sorted
and in the given language "caa" comes before
"aaa", therefore 'c' is before 'a' in output.
Similarly we can find other orders.
 */
/*
Time Complexity: O(N*len)+O(K+E), where N is the number of words in the dictionary, ‘len’ is the length up to the index
where the first inequality occurs, K = no. of nodes, and E = no. of edges.

Space Complexity: O(K) + O(K)+O(K)+O(K) ~ O(4K), O(K) for the indegree array, and O(K) for the queue data structure used
in BFS(where K = no.of nodes), O(K) for the answer array and O(K) for the adjacency list used in the algorithm.


 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class AlienDictionary_Leetcode_Premium {
    // Function to perform topological sorting using Kahn's algorithm
    private static List<Integer> topoSort(int V, List<List<Integer>> adj) {
        // Array to store the in-degree of each vertex
        int indegree[] = new int[V];

        // Calculate in-degrees for each vertex
        for (int i = 0; i < V; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }

        // Queue to store vertices with in-degree 0
        Queue<Integer> q = new LinkedList<>();

        // Enqueue vertices with in-degree 0
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        // List to store the topological order
        List<Integer> topo = new ArrayList<>();

        // Perform BFS until the queue is empty
        while (!q.isEmpty()) {
            int node = q.peek();
            q.remove();
            topo.add(node);

            // Update in-degrees of adjacent vertices and enqueue them if in-degree becomes 0
            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) q.add(it);
            }
        }

        return topo;
    }

    // Function to find the order of characters in the alien language
    public static String findOrder(String[] dict, int N, int K) {
        // Adjacency list representation of the graph
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            adj.add(new ArrayList<>());
        }

        // Build the graph based on the given dictionary
        for (int i = 0; i < N - 1; i++) {
            String s1 = dict[i];
            String s2 = dict[i + 1];
            int len = Math.min(s1.length(), s2.length());

            // Add directed edge based on the first differing character
            for (int ptr = 0; ptr < len; ptr++) {
                if (s1.charAt(ptr) != s2.charAt(ptr)) {
                    adj.get(s1.charAt(ptr) - 'a').add(s2.charAt(ptr) - 'a');
                    break;
                }
            }
        }

        // Perform topological sort to get the order of characters
        List<Integer> topo = topoSort(K, adj);

        // Convert the result to a string
        String ans = "";
        for (int it : topo) {
            ans = ans + (char) (it + (int) ('a'));
        }

        return ans;
    }

    public static void main(String[] args) {
        // Example usage
        int N = 5, K = 4;
        String[] dict = {"baa", "abcd", "abca", "cab", "cad"};
        String ans = findOrder(dict, N, K);

        // Print the result
        for (int i = 0; i < ans.length(); i++) {
            System.out.print(ans.charAt(i) + " ");
        }
        System.out.println("");
    }
}
