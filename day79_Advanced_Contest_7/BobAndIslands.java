package day79_Advanced_Contest_7;

/*
It looks like there's an issue with the formatting in your problem description. I'll interpret the description as follows:
Problem Description:
There are N islands in an ocean, and each island has an associated area represented by the array A. The goal is to travel
from the first island (Island 1) to the last island (Island N) with the minimum possible total cost. The cost to jump
from Island i to Island j is given by the absolute difference in area, |A[i] - A[j]|. You can jump to the next island
(i+1) or skip one island and jump to the one after that (i+2).

Problem Constraints:
1 <= N <= 105
0 <= A[i] <= 104

Input Format:
First and only argument A is an array of integers representing the area of each island.

Output Format:
Return an integer denoting the minimum possible total cost incurred before reaching island N.
If there are any specific errors or clarifications needed, please provide additional details.
 */
//Time Complexity: O(N LogN)
//Space Complexity : O(N)

import java.util.Arrays;

public class BobAndIslands {

    public int solve(int[] A) {
        int N = A.length;

        // Memoization array to store computed results
        int[] memo = new int[N];

        // Initialize memoization array with -1 (not visited)
        Arrays.fill(memo, -1);

        // Call the memoization helper function to get the result
        return memoizationHelper(A, N - 1, memo);
    }

    private int memoizationHelper(int[] A, int i, int[] memo) {
        // Base case: If the current island is the first island (i == 0), cost is 0.
        if (i == 0) {
            return 0;
        }

        // If the result for the current island is already computed, return it.
        if (memo[i] != -1) {
            return memo[i];
        }

        // Calculate the cost for jumping from the current island to the previous island (option1).
        int option1 = memoizationHelper(A, i - 1, memo) + Math.abs(A[i] - A[i - 1]);

        // Calculate the cost for skipping one island and jumping to the one before the previous island (option2).
        int option2 = (i >= 2) ? (memoizationHelper(A, i - 2, memo) + Math.abs(A[i] - A[i - 2])) : Integer.MAX_VALUE;

        // Store the minimum cost in the memoization array and return it.
        memo[i] = Math.min(option1, option2);
        return memo[i];
    }
}
