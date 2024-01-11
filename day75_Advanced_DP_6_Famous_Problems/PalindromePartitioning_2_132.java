package day75_Advanced_DP_6_Famous_Problems;
/*
Given a string s, partition s such that every substring of the partition is a palindrome
Return the minimum cuts needed for a palindrome partitioning of s.
Example 1:
Input: s = "aab"
Output: 1
Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
Example 2:
Input: s = "a"
Output: 0
Example 3:
Input: s = "ab"
Output: 1
 */
/*
Time Complexity: O(N^2 * N/2)  (N/2) to check if the substring is a palindrome
Reason: There are a total of N states and inside each state, a loop of size N(apparently) is running.

Space Complexity: O(N) + Auxiliary stack space O(N)
Reason: The first O(N) is for the dp array of size N.
 */

import java.util.Arrays;

public class PalindromePartitioning_2_132 {

    // Helper function to check if a substring is a palindrome
    static boolean isPalindrome(int start, int end, String s) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }

    // Recursive function to calculate the minimum cuts needed for palindrome partitioning
    static int calculateMinCuts(int start, int n, String str, int[] dp) {
        // Base case: if we have reached the end of the string
        if (start == n)
            return 0;

        // If the result is already computed, return it
        if (dp[start] != -1)
            return dp[start];

        int minCuts = Integer.MAX_VALUE;

        // Iterate over all possible substrings starting from 'start'
        for (int end = start; end < n; end++) {
            if (isPalindrome(start, end, str)) {
                // If the current substring is a palindrome, calculate the cost
                int cost = 1 + calculateMinCuts(end + 1, n, str, dp);
                minCuts = Math.min(minCuts, cost);
            }
        }

        // Memoize the result and return
        return dp[start] = minCuts;
    }

    // Function to find the minimum number of partitions needed for palindrome partitioning
    static int palindromePartitioning(String str) {
        int n = str.length();
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        // Calculate the minimum cuts recursively
        int minCuts = calculateMinCuts(0, n, str, dp);

        // Return the result minus 1 (since the original string is considered a partition)
        return minCuts - 1;
    }

    public static void main(String[] args) {
        String str = "BABABCBADCEDE";
        int partitions = palindromePartitioning(str);
        System.out.println("The minimum number of partitions: " + partitions);
    }
}
