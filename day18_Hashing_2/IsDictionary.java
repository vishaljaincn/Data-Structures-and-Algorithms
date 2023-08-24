package day18_Hashing_2;

import java.util.ArrayList;
import java.util.HashMap;

/*
Surprisingly, in an alien language, they also use English lowercase letters, but possibly in a different order.
The order of the alphabet is some permutation of lowercase letters.

Given an array of words A of size N written in the alien language, and the order of the alphabet denoted by
string B of size 26, return 1 if and only if the given words are sorted lexicographically in this alien language else, return 0.
 */
public class IsDictionary {
    public static int solve(ArrayList<String> A, String B) {
        // Step 1: Create a HashMap to store the order of each character in the alien language
        HashMap<Character, Integer> orderMap = new HashMap<>();

        // Step 2: Store the order of each character in the alien language in the orderMap
        for (int i = 0; i < B.length(); i++) {
            orderMap.put(B.charAt(i), i);
        }

        // Step 3: Compare each adjacent pair of words in the ArrayList A
        for (int i = 0; i < A.size() - 1; i++) {
            String word1 = A.get(i);
            String word2 = A.get(i + 1);

            // Step 4: Find the minimum length between word1 and word2 to avoid index out of bounds
            int minLength = Math.min(word1.length(), word2.length());
            int j = 0;

            // Step 5: Compare characters in both words until a difference is found
            while (j < minLength && word1.charAt(j) == word2.charAt(j)) {
                j++;
            }

            // Step 6: If word1.charAt(j) > word2.charAt(j), then the words are not sorted lexicographically
            // Return 0 in this case, indicating that the words are not sorted
            if (j < minLength && orderMap.get(word1.charAt(j)) > orderMap.get(word2.charAt(j))) {
                return 0;
            }

            // Step 7: If word2 is a prefix of word1, they are not sorted lexicographically
            // Return 0 in this case, indicating that the words are not sorted
            if (j == minLength && word1.length() > word2.length()) {
                return 0;
            }
        }

        // Step 8: All pairs of adjacent words are sorted lexicographically
        // Return 1, indicating that the words are sorted
        return 1;
    }

    public static void main(String[] args) {
        // Sample input
        ArrayList<String> words = new ArrayList<>();
        words.add("apple");
        words.add("app");
        words.add("apricot");
        String alienOrder = "bcdefghizkalmnopqrstuvwxyj"; // Assuming this is the order of the alien language

        // Call the solve method to check if the words are sorted lexicographically in the alien language
        int result = IsDictionary.solve(words, alienOrder);

        // Display the result
        if (result == 1) {
            System.out.println("The words are sorted lexicographically in the alien language.");
        } else {
            System.out.println("The words are not sorted lexicographically in the alien language.");

        }
    }
}
