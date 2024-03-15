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
// Time complexity: O(n), where n is the length of the input string s.
// Space complexity: O(1), constant space used for storing counts and maximum length.
class LongestValidParenthesis_32 {
    public int longestValidParentheses(String s) {
        // Variables to keep track of counts and maximum length
        int leftCount = 0;
        int rightCount = 0;
        int maxLength = 0;

        // Traverse the string from left to right
        for (int i = 0; i < s.length(); i++) {
            // If current character is '('
            if (s.charAt(i) == '(') {
                leftCount++; // Increment count of '('
            } else {
                rightCount++; // Increment count of ')'
            }

            // If counts of '(' and ')' are equal
            if (leftCount == rightCount) {
                // Calculate the length of valid substring and update maxLength
                maxLength = Math.max(maxLength, 2 * rightCount);
            } else if (rightCount > leftCount) {
                // If ')' count exceeds '(' count, reset counts
                leftCount = rightCount = 0;
            }
        }

        // Reset counts for traversal from right to left
        leftCount = rightCount = 0;

        // Traverse the string from right to left
        for (int i = s.length() - 1; i >= 0; i--) {
            // If current character is '('
            if (s.charAt(i) == '(') {
                leftCount++; // Increment count of '('
            } else {
                rightCount++; // Increment count of ')'
            }

            // If counts of '(' and ')' are equal
            if (leftCount == rightCount) {
                // Calculate the length of valid substring and update maxLength
                maxLength = Math.max(maxLength, 2 * leftCount);
            } else if (leftCount > rightCount) {
                // If '(' count exceeds ')' count, reset counts
                leftCount = rightCount = 0;
            }
        }

        // Return the maximum length of valid substring found
        return maxLength;
    }
}
/*BELOW STRING IS A CLASSIC EXAMPLE WHY WE NEED TO ITERATE ON BOTH SIDES TO GET THE PROPER ANSWER
s = "(()"

Output
0
Expected
2
 */