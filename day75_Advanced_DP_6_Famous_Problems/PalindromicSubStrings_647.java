package day75_Advanced_DP_6_Famous_Problems;

/*
Given a string s, return the number of palindromic substrings in it.
A string is a palindrome when it reads the same backward as forward.
A substring is a contiguous sequence of characters within the string.
Example 1:
Input: s = "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".

Example 2:
Input: s = "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".

*/
// Time Complexity: O(N^2) where N is the length of the input string
//   - The primary loop iterates through each character of the input string
//   - For each character, the extendPalindrome method can have a worst-case time complexity of O(N)
//     as it may need to expand to both ends of the string
//   - Overall time complexity is O(N^2)
// Space Complexity: O(1) - Constant space usage
//   - The code uses only a constant amount of extra space regardless of the input size
public class PalindromicSubStrings_647 {
    // Variable to keep track of the count of palindromic substrings
    int count = 0;

    // Method to count palindromic substrings in the given string
    public int countSubstrings(String s) {
        // Check if the input string is null or empty, return 0 in such cases
        if (s == null || s.length() == 0) return 0;

        // Iterate through each character in the string as a potential midpoint of a palindrome
        for (int i = 0; i < s.length(); i++) { // i is the mid point
            // Expand around the current character assuming it as the center of an odd-length palindrome
            extendPalindrome(s, i, i); // odd length;

            // Expand around the current character and the next one assuming them as the center of an even-length palindrome
            extendPalindrome(s, i, i + 1); // even length
        }

        // Return the total count of palindromic substrings
        return count;
    }

    // Helper method to extend the palindrome from a given center in both directions
    private void extendPalindrome(String s, int left, int right) {
        // Continue expanding as long as the characters at the left and right pointers are equal
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            // Increment the count as a valid palindrome is found
            count++;
            // Move the pointers towards the center for further expansion
            left--;
            right++;
        }
    }
}
