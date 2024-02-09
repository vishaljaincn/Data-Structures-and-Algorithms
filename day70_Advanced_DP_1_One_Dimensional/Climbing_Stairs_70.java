package day70_Advanced_DP_1_One_Dimensional;

import java.util.Arrays;

/*
You are climbing a staircase. It takes n steps to reach the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Example 1:
Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps

Example 2:
Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step 
2. 1 step + 2 steps
3. 2 steps + 1 step

Constraints:
1 <= n <= 45
*/
/*
Time Complexity: O(N) - Linear time complexity due to the number of subproblems being solved once in a top-up manner.
Space Complexity: O(n) - Linear space complexity for the memo array, where n is the input size.
*/
class Climbing_Stairs_70 {
    public int climbStairs(int n) {
        // Create an array to store the computed results for dynamic programming (memoization)
        int[] memo = new int[n + 1];
        // Initialize the memo array with -1 to indicate that the result is not yet computed.
        Arrays.fill(memo, -1);
        return climbStairsHelper(n, memo);
    }

    private int climbStairsHelper(int n, int[] memo) {
        // Base cases: If there is 1 or 2 steps, there is only 1 way to climb.
        if (n == 1 || n == 2) {
            return n;
        }

        // Check if the result for the current n is already computed and stored in memo
        if (memo[n] != -1) {
            return memo[n];
        }

        // Recursive calls to calculate the number of ways to climb stairs.
        // F(n) = F(n-1) + F(n-2)
        int ways = climbStairsHelper(n - 1, memo) + climbStairsHelper(n - 2, memo);

        // Store the result in memo for future reference
        memo[n] = ways;

        return ways;
    }
}
