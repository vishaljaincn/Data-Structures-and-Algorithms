package day75_Advanced_DP_6_Famous_Problems;
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
// Time complexity: O(n^2)
// Space complexity: O(n)
public class LengthOfLongestIncreasingSubSequence_Tabulation_300_Not_Revised {

    // DO NOT MODIFY THE ARRAY. IT IS READ ONLY
    public int lis(final int[] A) {
        int n = A.length;
        int dp[] = new int[n]; // `dp[i]` stores the length of the longest increasing subsequence ending at index `i`
        int ans = 1; // `ans` stores the overall maximum length of the longest increasing subsequence

        for (int i = 0; i < n; i++) {
            int maxSeq = 0; // `maxSeq` stores the maximum length of a subsequence ending at index `i` that is strictly increasing from a previous index `j`
            for (int j = 0; j < i; j++) {
                if (A[i] > A[j]) { // if the current element is greater than the element at index `j`, consider the subsequence ending at `j`
                    maxSeq = Math.max(maxSeq, dp[j]); // update `maxSeq` with the maximum length of a subsequence ending at `j`
                }
            }
            dp[i] = 1 + maxSeq; // update `dp[i]` with the length of the longest increasing subsequence ending at `i`
            ans = Math.max(ans, dp[i]); // update `ans` with the overall maximum length of the longest increasing subsequence
        }
        return ans;
    }
}
