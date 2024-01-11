package day75_Advanced_DP_6_Famous_Problems;

import java.util.Arrays;
/*
Given an integer array nums, return the length of the longest strictly increasing subsequence

Example 1:
Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.

Example 2:
Input: nums = [0,1,0,3,2,3]
Output: 4

Example 3:
Input: nums = [7,7,7,7,7,7,7]
Output: 1
 */
/*
Time Complexity: O(N*N)
Reason: There are N*N states therefore at max ‘N*N’ new problems will be solved.

Space Complexity: O(N*N) + O(N)
Reason: We are using an auxiliary recursion stack space(O(N))
-(see the recursive tree, in the worst case we will go till N calls at a time) and a 2D array ( O(N*N+1)).
 */
class LengthOfLongestIncreasingSubSequence_Memoization_300 {

    // Function to find the length of the longest increasing subsequence
    static int getAns(int arr[], int n, int ind, int prev_index, int[][] dp) {
        // Base condition: If we reach the end of the array, return 0
        if (ind == n) {
            return 0;
        }

        // If the result for the current state is already calculated, return it
        if (dp[ind][prev_index + 1] != -1) {
            return dp[ind][prev_index + 1];
        }

        // Option 1: Do not take the current element
        int notTake = 0 + getAns(arr, n, ind + 1, prev_index, dp);

        // Option 2: Take the current element if it is greater than the previous element
        int take = 0;

        if (prev_index == -1 || arr[ind] > arr[prev_index]) {
            take = 1 + getAns(arr, n, ind + 1, ind, dp);
        }

        // Store the result in the memoization table and return the maximum of the two options
        dp[ind][prev_index + 1] = Math.max(notTake, take);

        return dp[ind][prev_index + 1];
    }

    // Function to find the length of the longest increasing subsequence
    static int longestIncreasingSubsequence(int arr[], int n) {
        // Create a memoization table to store results for subproblems
        int dp[][] = new int[n][n + 1];

        // Initialize dp array with -1 to mark states as not calculated yet
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        // Start the recursive function with initial values
        return getAns(arr, n, 0, -1, dp);
    }

    public static void main(String args[]) {
        int arr[] = {10, 9, 2, 5, 3, 7, 101, 18};

        int n = arr.length;

        // Print the length of the longest increasing subsequence
        System.out.println("The length of the longest increasing subsequence is " + longestIncreasingSubsequence(arr, n));
    }
}
