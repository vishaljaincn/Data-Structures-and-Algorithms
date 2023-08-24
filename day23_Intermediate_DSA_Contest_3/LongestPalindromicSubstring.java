package day23_Intermediate_DSA_Contest_3;
/*
Given a string A of length N, find the length of longest palindromic substring that could be made from these letters
 */

import java.util.HashMap;
import java.util.Map;

public class LongestPalindromicSubstring {

    // Function to calculate the length of the longest palindromic substring using character frequencies
    public static int longestPalindromicSubstringLength(String s) {
        // Create a map to store the frequency of each character in the string
        Map<Character, Integer> freq = new HashMap<>();

        int n = s.length();
        // Count the frequency of each character in the string
        for (int i = 0; i < n; i++) {
            char currentCharacter = s.charAt(i);
            freq.put(currentCharacter, freq.getOrDefault(currentCharacter, 0) + 1);
        }

        int longestLength = 0; // Variable to store the length of the longest palindromic substring
        boolean hasOddFreq = false; // Flag to track whether there's a character with odd frequency

        // Iterate through the frequency values of each character
        for (int charFreq : freq.values()) {
            if (charFreq % 2 == 0) {
                // If the character frequency is even, add it to the longest length
                longestLength += charFreq;
            } else {
                // If the character frequency is odd, add (charFreq - 1) to the longest length
                longestLength += charFreq - 1;
                hasOddFreq = true; // Set the flag to true, indicating an odd frequency character
            }
        }

        // If there is a character with odd frequency, add 1 to the longest length
        if (hasOddFreq) {
            longestLength += 1;
        }

        return longestLength; // Return the final longest length
    }

    public static void main(String[] args) {
        String stringA = "abccccdd";
        int result = longestPalindromicSubstringLength(stringA);
        System.out.println(result);  // Output: 7 (palindrome: "dccaccd")
    }
}
