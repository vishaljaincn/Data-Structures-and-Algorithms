package day75_Advanced_DP_6_Famous_Problems;

/*
Given a string containing just the characters '(' and ')', return the length of the longest valid (well-formed) parentheses
substring

Example 1:
Input: s = "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()".
Example 2:
Input: s = ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()".
Example 3:
Input: s = ""
Output: 0
 */
// Time Complexity: O(n) - Single pass through the string
// Space Complexity: O(n) - Additional space used for the dp array
public class LongestValidParenthesis_32 {
    // Function to find the length of the longest valid parentheses substring
    public int longestValidParentheses(String A) {

        int n = A.length();
        int[] dp = new int[n]; // Array to store the length of valid parentheses substring ending at each index

        int ans = 0;
        for (int i = 1; i < n; i++) {
            char ch = A.charAt(i);
            if (ch == ')') {
                // Check if the current character is ')' and the previous character is '('
                if (A.charAt(i - 1) == '(') {
                    // If true, update dp[i] with length of valid parentheses substring ending at i-2 (if i-2 is valid)
                    dp[i] = (i - 2 >= 0) ? dp[i - 2] + 2 : 2;
                } else if (i - dp[i - 1] - 1 >= 0 && A.charAt(i - dp[i - 1] - 1) == '(') {
                    // If true, update dp[i] with length of valid parentheses substring ending at i-1 and i-2 (if i-2 is valid)
                    dp[i] = 2 + dp[i - 1];
                    dp[i] = (i - dp[i] >= 0) ? dp[i - dp[i]] + dp[i] : dp[i];
                }
            }
            ans = Math.max(ans, dp[i]); // Update the overall maximum length
        }
        return ans; // Return the overall maximum length of valid parentheses substring
    }

}
