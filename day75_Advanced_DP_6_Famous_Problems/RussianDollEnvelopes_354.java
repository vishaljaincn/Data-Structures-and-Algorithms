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
class RussianDollEnvelopes_354 {
    // Function to find the length of the longest increasing subsequence of envelopes
    static int russianDollEnvelopes(int[][] envelopes) {
        // Sort the envelopes based on their widths
        Arrays.sort(envelopes, (a, b) -> a[0] - b[0]);

        // Create a memoization table to store results for subproblems
        int[][] dp = new int[envelopes.length][envelopes.length];

        // Initialize dp array with -1 to mark states as not calculated yet
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        // Start the recursive function with initial values
        return maxRussianDolls(envelopes, 0, -1, dp);
    }

    // Recursive function to find the maximum number of envelopes that can be Russian dolled
    static int maxRussianDolls(int[][] envelopes, int currentIndex, int prevIndex, int[][] dp) {
        // Base condition: If we reach the end of the array, return 0
        if (currentIndex == envelopes.length) {
            return 0;
        }

        // If the result for the current state is already calculated, return it
        if (dp[currentIndex][prevIndex + 1] != -1) {
            return dp[currentIndex][prevIndex + 1];
        }

        // Option 1: Do not take the current envelope
        int notTake = maxRussianDolls(envelopes, currentIndex + 1, prevIndex, dp);

        // Option 2: Take the current envelope if it can fit inside the previous one
        int take = 0;
        if (prevIndex == -1 || (envelopes[currentIndex][0] > envelopes[prevIndex][0] && envelopes[currentIndex][1] > envelopes[prevIndex][1])) {
            take = 1 + maxRussianDolls(envelopes, currentIndex + 1, currentIndex, dp);
        }

        // Store the result in the memoization table and return the maximum of the two options
        dp[currentIndex][prevIndex + 1] = Math.max(notTake, take);

        return dp[currentIndex][prevIndex + 1];
    }

    public static void main(String[] args) {
        int[][] envelopes = {{5, 4}, {6, 4}, {6, 7}, {2, 3}};
        System.out.println("The maximum number of envelopes that can be Russian dolled is: " + russianDollEnvelopes(envelopes));
    }
}
