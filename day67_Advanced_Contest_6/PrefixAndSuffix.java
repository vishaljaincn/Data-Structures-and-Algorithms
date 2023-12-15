package day67_Advanced_Contest_6;
/*
given a list of N words denoted by string array of size N
you have to answer Q queries denoted by string array B, for each query you have a string S of size M, find the number
of words in the list A which have String S as a prefix and suffix,
Note - the size of M for all strings in the queries remains same
give java code which use tries and has a time complexity of less than N^2
 */
// Time Complexity: O(N * K + Q * M),
//   where N - Length of String array A,
//         K - Average length of words in String Array A,
//         Q - Length of String array B,
//         M - Size of M for all strings in the queries(array), remains the same

// Space Complexity: O(N * K) for storing the Trie.

import java.util.ArrayList;
import java.util.Arrays;

// Trie Node class
class Node {
    Node links[] = new Node[26];  // Array to represent links to child nodes for each character
    int cntEndWith = 0;  // Counter for the number of words that end with the current node
    int cntPrefix = 0;   // Counter for the number of words that have the current node as a prefix

    public Node() {
    }

    // Checks if the current node has a child node with the given character
    boolean containsKey(char ch) {
        return (links[ch - 'a'] != null);
    }

    // Retrieves the child node corresponding to the given character
    Node get(char ch) {
        return links[ch - 'a'];
    }

    // Adds a child node with the given character to the current node
    void put(char ch, Node node) {
        links[ch - 'a'] = node;
    }

    // Increments the counter for the number of words that end with the current node
    void increaseEnd() {
        cntEndWith++;
    }

    // Increments the counter for the number of words that have the current node as a prefix
    void increasePrefix() {
        cntPrefix++;
    }

    // Decrements the counter for the number of words that end with the current node
    void deleteEnd() {
        cntEndWith--;
    }

    // Decrements the counter for the number of words that have the current node as a prefix
    void reducePrefix() {
        cntPrefix--;
    }

    // Returns the counter for the number of words that end with the current node
    int getEnd() {
        return cntEndWith;
    }

    // Returns the counter for the number of words that have the current node as a prefix
    int getPrefix() {
        return cntPrefix;
    }
}

// Trie class
class Trie {
    private Node root;

    public Trie() {
        root = new Node();
    }

    // Insert a word into the Trie
    public void insert(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            // Check if the current character is already a child of the current node
            if (!node.containsKey(word.charAt(i))) {
                // If not, create a new node and add it as a child
                node.put(word.charAt(i), new Node());
            }
            // Move to the next node in the Trie
            node = node.get(word.charAt(i));
            // Increase the prefix count for the current node
            node.increasePrefix();
        }
        // Increment the count for words ending with the last character of the input word
        node.increaseEnd();
    }

    // Count the number of words starting with the given prefix
    public int countWordsStartingWith(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            // Traverse through the Trie to find the node corresponding to each character
            if (node.containsKey(word.charAt(i))) {
                node = node.get(word.charAt(i));
            } else {
                // If the character is not found, no words have the given prefix
                return 0;
            }
        }
        // Return the count of words that have the given prefix
        return node.getPrefix();
    }
}

// Class for solving the given problem
public class PrefixAndSuffix {
    Trie trie = new Trie();

    public ArrayList<Integer> solve(ArrayList<String> A, ArrayList<String> B) {
        // Result list to store the answers for each query
        ArrayList<Integer> result = new ArrayList<>();

        // Number of words in the input list
        int N = A.size();

        // Number of queries
        int Q = B.size();

        // Length of each query string
        int M = B.get(0).length();

        // Iterate through the list of words to build the Trie
        for (int i = 0; i < N; i++) {
            // Get the currentString word from the list
            String currentString = A.get(i);

            // Skip words that are shorter than the length of the queries
            if (currentString.length() < M) {
                continue;
            }

            // Initialize pointers for comparing the prefix and suffix
            int X = 0;
            int Y = currentString.length() - M;

            // Compare the prefix and suffix of the currentString word
            while (X < M) {
                // Break the loop if a mismatch is found
                if (currentString.charAt(X) != currentString.charAt(Y)) {
                    break;
                }
                // Move to the next character in the prefix and suffix
                X++;
                Y++;
            }

            // Insert the current word into the Trie if the prefix and suffix match
            trie.insert(currentString);
        }

        // Process each query and add the count to the result list
        for (int i = 0; i < Q; i++) {
            result.add(trie.countWordsStartingWith(B.get(i)));
        }

        // Return the final result
        return result;
    }

    // Main method for testing
    public static void main(String[] args) {
        // Example inputs
        ArrayList<String> words = new ArrayList<>(Arrays.asList("ababa", "aabbvaaab", "aecdsaaec", "abaaxbqaba"));
        ArrayList<String> queries = new ArrayList<>(Arrays.asList("aba", "aec", "abb", "aab"));

        // Create an instance of the PrefixAndSuffix class
        PrefixAndSuffix solution = new PrefixAndSuffix();

        // Solve the problem and get the result
        ArrayList<Integer> result = solution.solve(words, queries);

        // Print the result
        System.out.println("Result: " + result);
    }
}
