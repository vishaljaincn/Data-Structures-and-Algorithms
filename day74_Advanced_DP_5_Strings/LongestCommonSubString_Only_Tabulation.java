package day74_Advanced_DP_5_Strings;

/*
Problem statement
You are given two strings, 'str1' and 'str2'. You have to find the length of the longest common substring.
A substring is a continuous segment of a string. For example, "bcd" is a substring of "abcd", while "acd" or "cda" are not.
Example:
Input: ‘str1’ = “abcjklp” , ‘str2’ = “acjkp”.
Output: 3
Explanation:  The longest common substring between ‘str1’ and ‘str2’ is “cjk”, of length 3.
 */
/*
Time Complexity: O(N*M)
Reason: There are two nested loops

Space Complexity: O(N*M)
Reason: We are using an external array of size ‘N*M)’. Stack Space is eliminated.
 */

class LongestCommonSubString_Only_Tabulation {
    // Function to find the length of the Longest Common Substring (LCS)
    static int lcs(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        // Create a 2D array to store LCS lengths
        int[][] dp = new int[n + 1][m + 1];
        int ans = 0; // Initialize a variable to store the maximum LCS length

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // If the characters at the current indices are the same, extend the LCS
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    int val = 1 + dp[i - 1][j - 1];
                    dp[i][j] = val;
                    ans = Math.max(ans, val); // Update the maximum LCS length
                } else {
                    dp[i][j] = 0; // Reset LCS length if characters don't match
                }
            }
        }

        return ans; // Return the length of the Longest Common Substring (LCS)
    }

    public static void main(String args[]) {
        String s1 = "abcjklp";
        String s2 = "acjkp";

        // Call the lcs function and print the result
        System.out.println("The Length of Longest Common Substring is " + lcs(s1, s2));
    }
}
