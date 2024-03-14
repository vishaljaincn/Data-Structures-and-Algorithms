package day74_Advanced_DP_5_Strings;

/*
Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:
'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).
Example 1:
Input: s = "aa", p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".

Example 2:
Input: s = "aa", p = "*"
Output: true
Explanation: '*' matches any sequence.

Example 3:
Input: s = "cb", p = "?a"
Output: false
Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
 */
/*
Time Complexity: O(N*M)
Reason: There are N*M states therefore at max ‘N*M’ new problems will be solved.

Space Complexity: O(N*M) + O(N+M)
Reason: We are using a recursion stack space(O(N+M)) and a 2D array ( O(N*M)).
 */
class WildcardMatching_44 {
    // Main function to check if S1 matches the wildcard pattern S2
    static boolean isMatch(String S1, String S2) {
        int n = S1.length();
        int m = S2.length();

        Boolean dp[][] = new Boolean[n][m];

        // Call the recursive helper function
        return wildcardMatchingUtil(S1, S2, n - 1, m - 1, dp);
    }

    // Helper function to check if all characters from index 0 to j in S2 are '*'
    static Boolean isAllStars(String S2, int j) {
        for (int idx = 0; idx <= j; idx++) {
            if (S2.charAt(idx) != '*')
                return false;
        }
        return true;
    }

    // Recursive function to perform wildcard pattern matching
    static Boolean wildcardMatchingUtil(String S1, String S2, int i, int j, Boolean[][] dp) {
        // Base Cases
        if (i < 0 && j < 0)
            return true; // Both strings are empty, and the pattern matches.
        if (j < 0 && i >= 0)
            return false; // If String S2 is exhausted but String S1 is still pending, return false
        if (i < 0 && j >= 0)
            return isAllStars(S2, j); // S1 is empty, check if remaining characters in S2 are all '*'.

        // If the result is already computed, return it.
        if (dp[i][j] != null) {
            return dp[i][j];
        }

        // If the characters match or S1 has a '?', continue matching the rest of the strings.
        if (S1.charAt(i) == S2.charAt(j) || S2.charAt(j) == '?')
            return dp[i][j] = wildcardMatchingUtil(S1, S2, i - 1, j - 1, dp);
        else {
            if (S2.charAt(j) == '*') {
                // Two possibilities when encountering '*':
                // 1. '*' matches zero characters in S1.
                // 2. '*' matches one or more characters in S1.
                return dp[i][j] = (wildcardMatchingUtil(S1, S2, i, j - 1, dp) || wildcardMatchingUtil(S1, S2, i - 1, j, dp));
            } else {
                // Characters don't match, and S2[j] is not '*'.
                return false;
            }
        }
    }
}
