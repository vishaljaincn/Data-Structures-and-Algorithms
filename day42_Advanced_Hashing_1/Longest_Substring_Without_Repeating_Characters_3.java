package day42_Advanced_Hashing_1;

/*
Given a string s, find the length of the longest substring without repeating characters.

Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
/*
Time complexity: O(n), where n is the length of the input string.
Space complexity: O(min(n, m)), where m is the size of the character set (26 for lowercase English letters).
 */

import java.util.HashMap;

class Longest_Substring_Without_Repeating_Characters_3 {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();  // Get the length of the input string
        int start = 0;  // Initialize the start pointer for the sliding window
        int length = 0;  // Initialize the length of the longest substring without repeating characters
        HashMap<Character, Integer> hm = new HashMap<>();  // Create a HashMap to store the frequency of characters

        // Iterate through the string using the end pointer
        for (int end = 0; end < n; end++) {
            hm.put(s.charAt(end), hm.getOrDefault(s.charAt(end), 0) + 1);  // Update the character frequency in the HashMap

            // Check for repeating characters in the current substring
            while (hm.get(s.charAt(end)) > 1) {
                hm.put(s.charAt(start), hm.get(s.charAt(start)) - 1);  // Decrease the frequency of the character at the start pointer

                // If the frequency becomes zero, remove the character from the HashMap
                if (hm.get(s.charAt(start)) == 0) {
                    hm.remove(s.charAt(start));
                }

                start++;  // Move the start pointer forward to remove the repeating character
            }

            // Update the length of the longest substring
            length = Math.max(length, hm.size());
        }

        return length;  // Return the length of the longest substring without repeating characters
    }
}
