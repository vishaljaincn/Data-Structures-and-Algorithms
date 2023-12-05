package day63_Advanced_Tries_2;
//TC - O(N * 32) + O(M * 32)
//SC - O(N * 32) = which can be treated as O(N)

import java.util.List;

//find the maximum XOR value between elements(1st element should be from 1st array, 2nd element should be from 2nd array)
// of two arrays
class Node {
    Node[] links = new Node[2];// Array to store links to child nodes (0 and 1)

    Node() {

    }

    // Check if a child node exists for the given bit
    boolean contains(int bit) {
        return links[bit] != null;
    }

    // Put a child node at the given bit
    void put(int bit, Node n) {
        links[bit] = n;
    }

    // Get the child node at the given bit
    Node get(int bit) {
        return links[bit];
    }
}

class Trie {
    private Node root;  // Root node of the Trie

    Trie() {
        root = new Node();
    }

    // Insert a number into the Trie
    void insert(int num) {
        Node node = root;
        for (int i = 31; i >= 0; i--) {
            // Extract the i-th bit of the number
            int bit = (num & (1 << i)) == (1 << i) ? 1 : 0;

            // If the current node doesn't have a child with the current bit, create one
            if (!node.contains(bit)) {
                node.put(bit, new Node());
            }

            // Move to the child node corresponding to the current bit
            node = node.get(bit);
        }
    }

    // Get the maximum XOR value for a given number
    int getMax(int num) {
        Node node = root;
        int maxNum = 0;
        for (int i = 31; i >= 0; i--) {
            // Extract the i-th bit of the number
            int bit = (num & (1 << i)) == (1 << i) ? 1 : 0;

            // If there exists a child node with the opposite bit, update maxNum and move to that node
            if (node.contains(1 - bit)) {
                maxNum = maxNum | (1 << i);
                node = node.get(1 - bit);
            } else {
                // Otherwise, move to the child node with the same bit
                node = node.get(bit);
            }
        }
        return maxNum;
    }
}

public class MaxXor {
    // Function to find the maximum XOR value between elements of two arrays
    static int maxXOR(int n, int m, List<Integer> arr1, List<Integer> arr2) {
        Trie T = new Trie();

        // Insert elements from the first array into the Trie
        for (int it : arr1) {
            T.insert(it);
        }

        int maxi = 0;

        // Find the maximum XOR value for each element in the second array
        for (int it : arr2) {
            maxi = Math.max(maxi, T.getMax(it));
        }

        return maxi;
    }
}
