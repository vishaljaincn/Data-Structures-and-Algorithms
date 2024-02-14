package day42_Advanced_Hashing_1;

/*
Given a string, find the length of the longest substring T that contains at most k distinct characters.

Example 1:

Input: s = "eceba", k = 2
Output: 3
Explanation: T is "ece" which its length is 3.
Example 2:

Input: s = "aa", k = 1
Output: 2
Explanation: T is "aa" which its length is 2.
 */
// Time complexity: O(n), where n is the length of the input string
// Space complexity: O(k), where k is the number of distinct characters (constant for this problem)

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMost_K_DistinctCharacters_340_premium {
    // Function to find the length of the longest substring with at most k distinct characters
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // Check for edge cases
        if (s == null || s.length() == 0 || k == 0) {
            return 0;
        }

        int n = s.length();
        int start = 0; // Start index of the current substring
        int maxLength = 0; // Maximum length of the substring

        // Map to store the frequency of each character in the current window
        Map<Character, Integer> charFrequency = new HashMap<>();

        // Iterate through the string using a sliding window approach
        for (int end = 0; end < n; end++) {
            char currentChar = s.charAt(end);
            charFrequency.put(currentChar, charFrequency.getOrDefault(currentChar, 0) + 1);

            // Shrink the window until the number of distinct characters is <= k
            while (charFrequency.size() > k) {
                char startChar = s.charAt(start);
                charFrequency.put(startChar, charFrequency.get(startChar) - 1);

                // Remove character from the map if its frequency becomes 0
                if (charFrequency.get(startChar) == 0) {
                    charFrequency.remove(startChar);
                }
                start++;
            }

            // Update the maximum length of the substring
            maxLength = Math.max(maxLength, end - start + 1);
        }

        // Return the final maximum length of the substring with at most k distinct characters
        return maxLength;
    }
}
