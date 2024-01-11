package day75_Advanced_DP_6_Famous_Problems;

import java.util.Arrays;

/*
You are given a 2D array of integers envelopes where envelopes[i] = [wi, hi] represents the width and the height of an envelope.
One envelope can fit into another if and only if both the width and height of one envelope are greater than the other envelope's
width and height.
Return the maximum number of envelopes you can Russian doll (i.e., put one inside the other).
Note: You cannot rotate an envelope.
Example 1:
Input: envelopes = [[5,4],[6,4],[6,7],[2,3]]
Output: 3
Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
Example 2:
Input: envelopes = [[1,1],[1,1],[1,1]]
Output: 1
 */
// Time Complexity: O(n^2) + O(n logn) - Two nested loops iterating through each envelope, and n logn for sorting
// Space Complexity: O(n) - Space required for the dp array
public class RussianDollEnvelopes_354 {
    // Method to calculate the maximum number of envelopes that can be Russian doll-ed
    public int solve(int[][] envelopes) {
        int n = envelopes.length;

        // Array to store the length of the maximum increasing subsequence ending at each index
        int dp[] = new int[n];

        // Sorting the envelopes based on their widths in ascending order
        Arrays.sort(envelopes, (a, b) -> a[0] - b[0]);

        // Initialize the answer to 1, as each envelope can be considered as a sequence of length 1
        int ans = 1;

        // Iterate through each envelope
        for (int i = 0; i < n; i++) {
            // Variable to store the length of the maximum increasing subsequence ending at index i
            int maxSeq = 0;

            // Iterate through the envelopes before the current index
            for (int j = 0; j < i; j++) {
                // Check if the j-th envelope can fit inside the i-th envelope
                if (envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1]) {
                    // Update the length of the maximum increasing subsequence ending at index j
                    maxSeq = Math.max(maxSeq, dp[j]);
                }
            }

            // Length of the maximum increasing subsequence ending at index i is 1 plus the calculated maxSeq
            dp[i] = 1 + maxSeq;

            // Update the overall answer with the maximum length of increasing subsequences
            ans = Math.max(ans, dp[i]);
        }

        // Return the final answer
        return ans;
    }
}
