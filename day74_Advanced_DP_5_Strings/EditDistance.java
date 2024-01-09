package day74_Advanced_DP_5_Strings;
/*
Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
You have the following three operations permitted on a word:

Insert a character
Delete a character
Replace a character

Example 1:
Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation:
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')

Example 2:
Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation:
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')
 */

/*
 * Time Complexity: O(N*M)
 * Reason: There are N*M states; therefore, at max ‘N*M’ new problems will be solved.
 *
 * Space Complexity: O(N*M) + O(N+M)
 * Reason: We are using a recursion stack space(O(N+M)) and a 2D array ( O(N*M)).
 */

import java.util.Arrays;

class EditDistance {

    // Function to calculate the minimum edit distance between two strings
    static int minDistance(String S1, String S2) {
        int n = S1.length();
        int m = S2.length();

        // 2D array to store the computed results of subproblems
        int[][] dp = new int[n][m];

        // Initializing the 2D array with -1 to mark uncomputed results
        for (int row[] : dp)
            Arrays.fill(row, -1);

        // Call the recursive helper function
        return editDistanceUtil(S1, S2, n - 1, m - 1, dp);
    }

    // Recursive helper function to calculate the minimum edit distance
    static int editDistanceUtil(String S1, String S2, int i, int j, int[][] dp) {
        // Base cases
        if (i < 0) return j + 1;
        if (j < 0) return i + 1;

        // If the result is already computed, return it
        if (dp[i][j] != -1) return dp[i][j];

        // If the characters at the current positions match, no edit is needed
        if (S1.charAt(i) == S2.charAt(j)) return dp[i][j] = editDistanceUtil(S1, S2, i - 1, j - 1, dp);

            // Minimum of three choices:
            // 1. Replace the character in S1 with the character in S2.
            // 2. Delete the character in S1.
            // 3. Insert the character from S2 into S1.
        else
            return dp[i][j] = 1 + Math.min(editDistanceUtil(S1, S2, i - 1, j - 1, dp), Math.min(editDistanceUtil(S1, S2, i - 1, j, dp), editDistanceUtil(S1, S2, i, j - 1, dp)));
    }
}
