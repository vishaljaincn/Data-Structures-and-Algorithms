package day62_Advanced_Tries_1;

class Node {
    Node links[] = new Node[26]; // Array to represent links to child nodes for each letter of the alphabet
    boolean flag = false; // Flag to indicate if the current node represents the end of a word

    public Node() {
        // Constructor for Node class
    }

    boolean containsKey(char ch) {
        // Check if the current node has a child node for the given character
        return (links[ch - 'a'] != null);
    }

    Node get(char ch) {
        // Get the child node corresponding to the given character
        return links[ch - 'a'];
    }

    void put(char ch, Node node) {
        // Add a child node for the given character
        links[ch - 'a'] = node;
    }

    void setEnd() {
        // Mark the current node as the end of a word
        flag = true;
    }

    void removeEnd() {
        // Remove the end-of-word marker for the current node
        flag = false;
    }

    boolean isEnd() {
        // Check if the current node represents the end of a word
        return flag;
    }
}

public class ImplementTrie_208 {
    private static Node root; // Root node of the trie

    // Initialize your data structure here
    ImplementTrie_208() {
        root = new Node(); // Create an empty root node when the Trie is initialized
    }

    // Inserts a word into the trie
    //TC - O(length of the word)
    public static void insert(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            // Traverse through the trie, adding nodes for each character if not already present
            if (!node.containsKey(word.charAt(i))) {
                node.put(word.charAt(i), new Node());
            }
            node = node.get(word.charAt(i));
        }
        node.setEnd(); // Mark the last node as the end of the inserted word
    }

    // Returns if the word is in the trie
    //TC - O(length of the word)
    public static boolean search(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            // Traverse through the trie to check if each character of the word is present
            if (!node.containsKey(word.charAt(i))) {
                return false;
            }
            node = node.get(word.charAt(i));
        }
        // Check if the last node represents the end of a word
        return node.isEnd();
    }

    // Returns if there is any word in the trie that starts with the given prefix
    //TC - O(length of the word)
    public static boolean startsWith(String prefix) {
        Node node = root;
        for (int i = 0; i < prefix.length(); i++) {
            // Traverse through the trie to check if each character of the prefix is present
            if (!node.containsKey(prefix.charAt(i))) {
                return false;
            }
            node = node.get(prefix.charAt(i));
        }
        return true; // The prefix is present in the trie
    }

    // Deletes a word from the trie if it exists
    //TC - O(length of the word)
    public void delete(String word) {
        Node node = root;

        // If search(word) == true, then you can delete
        if (search(word)) {
            for (int i = 0; i < word.length(); i++) {
                node = node.get(word.charAt(i));
            }
            if (node.isEnd()) {
                node.removeEnd(); // Remove the end-of-word marker for the last node of the word
            }
        }
    }
}
