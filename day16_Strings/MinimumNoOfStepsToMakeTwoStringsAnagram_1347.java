package day16_Strings;

/*
You are given two strings of the same length s and t. In one step you can choose any character of t and replace it with another character.

Return the minimum number of steps to make t an anagram of s.

An Anagram of a string is a string that contains the same characters with a different (or the same) ordering.

Example 1:

Input: s = "bab", t = "aba"
Output: 1
Explanation: Replace the first 'a' in t with b, t = "bba" which is anagram of s.
Example 2:

Input: s = "leetcode", t = "practice"
Output: 5
Explanation: Replace 'p', 'r', 'a', 'i' and 'c' from t with proper characters to make t anagram of s.
Example 3:

Input: s = "anagram", t = "mangaar"
Output: 0
Explanation: "anagram" and "mangaar" are anagrams.
 */

// Time Complexity: O(n), where n is the length of the input strings
// Space Complexity: O(1), assuming a constant-size array for character counts

class MinimumNoOfStepsToMakeTwoStringsAnagram_1347 {
    // Function to calculate the minimum steps to make two strings anagrams
    public int minSteps(String s, String t) {
        // Array to store the count of each character (assuming lowercase English letters)
        int[] charCount = new int[26];

        // Step 1: Count the occurrences of each character in string s
        for (char ch : s.toCharArray()) {
            charCount[ch - 'a']++;
        }

        // Step 2: Decrement the count for each character in string t
        // If a character is not present in s or occurs more in t, we need to make it an anagram
        for (char ch : t.toCharArray()) {
            charCount[ch - 'a']--;
        }

        int steps = 0;

        // Step 3: Adding the difference where string t has more instances than s.
        // Ignoring where t has fewer instances as they are redundant and
        // can be covered by the first case.
        // Count the total steps needed to make the strings anagrams
        for (int count : charCount) {
            if (count > 0) {
                steps += count;
            }
        }

        // The total steps needed to make the strings anagrams
        return steps;
    }
}
