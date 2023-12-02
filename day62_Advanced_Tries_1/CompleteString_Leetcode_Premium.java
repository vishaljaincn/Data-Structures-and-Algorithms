package day62_Advanced_Tries_1;
/*
Given a list of words ‘WORDLIST’, find the longest perfect word. A perfect word is a word in which all the possible prefixes are present in ‘WORDLIST’.

If more than one perfect word of the same length is present in the ‘WORDLIST’, return the word with the smallest lexicographical order. You can return an empty string if no such word is possible for the given input.

Input
["w", "wo", "wor", "wow", "worm", "work"]
["w","wo","wor","worl","world"]
["a","banana","app","appl","ap","apply","apple"]

Output
"work"
"world"
"apple"
 */
//class Node {
//    Node[] links = new Node[26];
//    boolean flag = false;
//
//    // Check if the current node has a child node with the given character
//    boolean containsKey(char ch) {
//        return links[ch - 'a'] != null;
//    }
//
//    // Retrieves the child node corresponding to the given character
//    Node get(char ch) {
//        return links[ch - 'a'];
//    }
//
//    // Adds a child node with the given character to the current node
//    void put(char ch, Node node) {
//        links[ch - 'a'] = node;
//    }
//
//    // Marks the current node as the end of a word
//    void setEnd() {
//        flag = true;
//    }
//
//    // Checks if the current node represents the end of a word
//    boolean isEnd() {
//        return flag;
//    }
//}

class Trie {
    private Node root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new Node();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        Node node = root;
        int wordLength = word.length();
        for (int i = 0; i < wordLength; i++) {
            char currChar = word.charAt(i);
            // Check if the current character is already a child of the current node
            if (!node.containsKey(currChar)) {
                // If not, create a new node and add it as a child
                node.put(currChar, new Node());
            }
            // Move to the next node in the Trie
            node = node.get(currChar);
        }
        // Mark the last node as the end of the inserted word
        node.setEnd();
    }

    // Checks if all prefixes of the given word exist in the Trie
    public boolean checkIfAllPrefixExists(String word) {
        // Start from the root of the Trie
        Node node = root;

        // Iterate through each character in the given word
        for (int i = 0; i < word.length(); ++i) {
            // Check if the current character is a child of the current node
            if (node.containsKey(word.charAt(i))) {
                // Move to the next node in the Trie
                node = node.get(word.charAt(i));

                // Check if the current node represents the end of a word
                if (!node.isEnd())
                    return false; // If not, the prefix doesn't exist in the Trie
            } else {
                // If the character is not found, the prefix doesn't exist in the Trie
                return false;
            }
        }

        // All prefixes exist in the Trie for the given word
        return true;
    }

}
//TC - O(N * Average length of each word)
class CompleteString_Leetcode_Premium {

    // Method to find the longest word with all prefixes existing in the Trie
    static String completeString(int n, String[] a) {
        Trie obj = new Trie();
        // Insert each word into the Trie
        for (String word : a) {
            obj.insert(word);
        }
        String longest = "";
        // Check each word in the array
        for (String word : a) {
            // Check if all prefixes of the current word exist in the Trie
            if (obj.checkIfAllPrefixExists(word)) {
                // If the current word is longer than the current longest, update longest
                if (word.length() > longest.length()) {
                    longest = word;
                } else if (word.length() == longest.length() && word.compareTo(longest) < 0) {
                    // If lengths are equal, choose lexicographically smaller word
                    longest = word;
                }
            }
        }
        // If no such word found, return "None"
        if (longest.equals("")) return "None";
        return longest;
    }
}
