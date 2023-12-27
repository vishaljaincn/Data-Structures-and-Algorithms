package day70_Advanced_DP_1_One_Dimensional;

import java.util.Arrays;

/*
Time Complexity: O(N)

Reason: The overlapping subproblems will return the answer in constant time O(1).
Therefore the total number of new subproblems we solve is ‘n’. Hence total time complexity is O(N).

Space Complexity: O(N)

Reason: We are using a recursion stack space(O(N)) and an array (again O(N)).
Therefore total space complexity will be O(N) + O(N) ≈ O(N)
 */
class Fibonacci_Memoization_Top_Down_DP {
    // Recursive function to calculate Fibonacci with memoization
    static int fib(int n, int[] dp) {
        // Base case: Fibonacci of 0 or 1 is the number itself
        if (n <= 1) {
            return n;
        }

        // If the Fibonacci value for 'n' is not computed yet, calculate and store it
        if (dp[n] != -1) {
            return dp[n];
        }

        // Calculate and memoize the Fibonacci value for 'n'
        return dp[n] = fib(n - 1, dp) + fib(n - 2, dp);
    }

    public static void main(String args[]) {
        // Input value for which Fibonacci needs to be calculated
        int n = 5;

        // Array to store computed Fibonacci values for memoization
        int dp[] = new int[n + 1];

        // Initialize memo array with default value -1 for memoization
        Arrays.fill(dp, -1);

        // Display the calculated Fibonacci value for 'n'
        System.out.println("Fibonacci of " + n + ": " + fib(n, dp));

    }
}
