package day16_Strings;

import java.util.*;
/*
Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
Example 2:

Input: strs = [""]
Output: [[""]]
Example 3:

Input: strs = ["a"]
Output: [["a"]]
 */

// Time complexity: O(N * K * log(K)), where N is the number of strings and K is the length of the longest string.
// Space complexity: O(N * K), primarily due to the HashMap storing groups of anagrams.


public class GroupAnagrams_49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Create a HashMap to store groups of anagrams
        Map<String, List<String>> anagramGroups = new HashMap<>();

        // Iterate through each string in the input array
        for (String str : strs) {
            // Convert the string to a character array, then sort the array
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);

            // Create a sorted string from the sorted character array
            String sortedStr = new String(charArray);

            // If the sorted string is not in the HashMap, add it with an empty list
            anagramGroups.putIfAbsent(sortedStr, new ArrayList<>());

            // Add the original string to the corresponding group in the HashMap
            anagramGroups.get(sortedStr).add(str);
        }

        // Return the values (lists of anagram groups) from the HashMap
        return new ArrayList<>(anagramGroups.values());
    }
}
