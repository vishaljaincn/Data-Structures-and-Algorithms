/*
Given a string of alphabetic characters. Return the count of distinct substrings of the string(including the empty string)
using the Trie data structure.
 */
package day62_Advanced_Tries_1;

// Trie Node class
class Noda {
    Noda links[] = new Noda[26];

    // Checks if the current node has a child node with the given character
    boolean containsKey(char ch) {
        return (links[ch - 'a'] != null);
    }

    // Retrieves the child node corresponding to the given character
    Noda get(char ch) {
        return links[ch - 'a'];
    }

    // Adds a child node with the given character to the current node
    void put(char ch, Noda node) {
        links[ch - 'a'] = node;
    }
}

//TC - O(N^2)
//Space Complexity: O(N^2 * 26), because in the worst case, all the substrings can be distinct and there will be a node for every substring.
//Number of substrings of a string of length n is (n * (n + 1) / 2). Hence in the worst case, space complexity will be O(n2).
//Usually it is very difficult to calculate the Space complexity of Tries for obvious reasons, so don't worry about it.
public class Number_Of_Distinct_Substrings_in_a_String_Using_Trie {
    // Function to count the total number of distinct substrings using Trie
    public static int countDistinctSubstrings(String s) {
        Noda root = new Noda();
        int n = s.length();
        int count = 0;

        // Iterate through each character in the string
        for (int i = 0; i < n; i++) {
            Noda node = root;

            // Iterate through each character from the current position to the end of the string
            for (int j = i; j < n; j++) {
                // Check if the current character is already a child of the current node in Trie
                if (!node.containsKey(s.charAt(j))) {
                    // If not, create a new node and add it as a child
                    node.put(s.charAt(j), new Noda());
                    count++; // Increment the count as a new distinct substring is found
                }
                // Move to the next node in the Trie
                node = node.get(s.charAt(j));
            }
        }
        // The total count of distinct substrings + the empty string
        return count + 1;
    }

    public static void main(String[] args) {

        // Example 1
        String s1 = "ababa";
        System.out.println("Total number of distinct substrings : " +
                countDistinctSubstrings(s1));

        // Example 2
        String s2 = "ccfdf";
        System.out.println("Total number of distinct substrings : " +
                countDistinctSubstrings(s2));

    }
}

