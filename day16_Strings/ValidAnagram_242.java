package day16_Strings;

import java.util.HashMap;
import java.util.Map;
/*
Given two strings s and t, return true if t is an anagram of s, and false otherwise.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically
using all the original letters exactly once.

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
 */

// Time complexity: O(n), Space complexity: O(n)

public class ValidAnagram_242 {
    public boolean isAnagram(String s, String t) {
        // Check if the lengths of the two strings are different
        if (s.length() != t.length()) {
            return false;
        }

        // Create a HashMap to store character frequencies in the first string
        Map<Character, Integer> charFrequency = new HashMap<>();

        // Update frequencies for characters in the first string
        for (char c : s.toCharArray()) {
            charFrequency.put(c, charFrequency.getOrDefault(c, 0) + 1);
        }

        // Check frequencies for characters in the second string
        for (char c : t.toCharArray()) {
            // If the character is not present in the HashMap or its frequency is zero,
            // the strings are not anagrams
            if (!charFrequency.containsKey(c) || charFrequency.get(c) == 0) {
                return false;
            }

            // Update the frequency of the character in the HashMap
            charFrequency.put(c, charFrequency.get(c) - 1);
        }

        // If all characters have been checked and frequencies are zero, the strings are anagrams
        return true;
    }
}
