package day62_Advanced_Tries_1;

/*
A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.

Implement the Trie class:

Trie(): Initializes the trie object.
void insert(string word): Inserts the string word into the trie.
int countWordsEqualTo(string word): Returns the number of instances of the string word in the trie.
int countWordsStartingWith(string prefix): Returns the number of strings in the trie that have the string prefix as a prefix.
void erase(string word): Erases the string word from the trie.
Constraints:

1 <= word.length, prefix.length <= 2000
word and prefix consist only of lowercase English letters.
At most 3 * 10^4 calls in total will be made to insert, countWordsEqualTo, countWordsStartingWith, and erase.
It is guaranteed that for any function call to erase, the string word will exist in the trie.

Example 1:

Input
["Trie", "insert", "insert", "countWordsEqualTo", "countWordsStartingWith", "erase", "countWordsEqualTo", "countWordsStartingWith", "erase", "countWordsStartingWith"]
[[], ["apple"], ["apple"], ["apple"], ["app"], ["apple"], ["apple"], ["app"], ["apple"], ["app"]]
Output
[null, null, null, 2, 2, null, 1, 1, null, 0]

Explanation
Trie trie = new Trie();
trie.insert("apple"); // Inserts "apple".
trie.insert("apple"); // Inserts another "apple".
trie.countWordsEqualTo("apple"); // There are two instances of "apple" so return 2.
trie.countWordsStartingWith("app"); // "app" is a prefix of "apple" so return 2.
trie.erase("apple"); // Erases one "apple".
trie.countWordsEqualTo("apple"); // Now there is only one instance of "apple" so return 1.
trie.countWordsStartingWith("app"); // return 1
trie.erase("apple"); // Erases "apple". Now the trie is empty.
trie.countWordsStartingWith("app"); // return 0
 */

class Nodes {
    Nodes links[] = new Nodes[26]; // Array to store links to child nodes for each character
    int cntEndWith = 0; // Counter for the number of words that end with the current node
    int cntPrefix = 0; // Counter for the number of words that have the current node as a prefix

    public Nodes() {
    }

    // Checks if the current node has a child node with the given character
    boolean containsKey(char ch) {
        return (links[ch - 'a'] != null);
    }

    // Retrieves the child node corresponding to the given character
    Nodes get(char ch) {
        return links[ch - 'a'];
    }

    // Adds a child node with the given character to the current node
    void put(char ch, Nodes node) {
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

public class ImplementTrie_2_Leetcode_Premium {
    private Nodes root;

    // Initialize your data structure here
    ImplementTrie_2_Leetcode_Premium() {
        root = new Nodes();
    }

    // Inserts a word into the trie
    //TC - O(length of the word)
    public void insert(String word) {
        Nodes node = root;
        for (int i = 0; i < word.length(); i++) {
            // Check if the current character is already a child of the current node
            if (!node.containsKey(word.charAt(i))) {
                // If not, create a new node and add it as a child
                node.put(word.charAt(i), new Nodes());
            }
            // Move to the next node in the Trie
            node = node.get(word.charAt(i));
            // Increase the prefix count for the current node
            node.increasePrefix();
        }
        // Increment the count for words ending with the last character of the input word
        node.increaseEnd();
    }

    // Returns the count of words in the trie that are equal to the given word
    //TC - O(length of the word)
    public int countWordsEqualTo(String word) {
        Nodes node = root;
        for (int i = 0; i < word.length(); i++) {
            // Traverse through the Trie to find the node corresponding to each character
            if (node.containsKey(word.charAt(i))) {
                node = node.get(word.charAt(i));
            } else {
                // If the character is not found, the word doesn't exist in the Trie
                return 0;
            }
        }
        // Return the count of words that end with the last character of the input word
        return node.getEnd();
    }

    // Returns the count of words in the trie that have the given prefix
    //TC - O(length of the word)
    public int countWordsStartingWith(String word) {
        Nodes node = root;
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

    // Removes a word from the trie
    // We are assuming that word is definitely present for deletion
    //TC - O(length of the word)
    public void erase(String word) {
        Nodes node = root;
        for (int i = 0; i < word.length(); i++) {
            // Traverse through the Trie to find the node corresponding to each character
            if (node.containsKey(word.charAt(i))) {
                // Move to the next node in the Trie
                node = node.get(word.charAt(i));
                // Decrease the prefix count for the current node
                node.reducePrefix();
            } else {
                // If the character is not found, the word doesn't exist in the Trie
                return;
            }
        }
        // Decrease the count for words ending with the last character of the input word
        node.deleteEnd();
    }

    public static void main(String args[]) {
        ImplementTrie_2_Leetcode_Premium T = new ImplementTrie_2_Leetcode_Premium();
        T.insert("apple");
        T.insert("apple");
        T.insert("apps");
        T.insert("apps");

        String word1 = "apps";
        System.out.println("Count Words Equal to " + word1 + " " + T.countWordsEqualTo(word1));

        String word2 = "abc";
        System.out.println("Count Words Equal to " + word2 + " " + T.countWordsEqualTo(word2));

        String word3 = "ap";
        System.out.println("Count Words Starting With " + word3 + " " + T.countWordsStartingWith(word3));

        String word4 = "appl";
        System.out.println("Count Words Starting With " + word4 + " " + T.countWordsStartingWith(word4));

        T.erase(word1);
        System.out.println("Count Words equal to " + word1 + " " + T.countWordsEqualTo(word1));
    }
}
