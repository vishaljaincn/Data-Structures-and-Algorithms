package day70_Advanced_DP_1_One_Dimensional;
/*
Time Complexity: O(N)

Reason: We are running a simple iterative loop

Space Complexity: O(N)

Reason: We are using an external array of size ‘n+1’.
 */

class Fibonacci_Tabulation_or_Iterative_Bottom_Up_DP {

    // Function to calculate the nth Fibonacci number using dynamic programming
    static int calculateFibonacci(int n) {
        // Create an array to store intermediate Fibonacci values
        int dp[] = new int[n + 1];

        // Base cases: the first two Fibonacci numbers
        dp[0] = 0;
        dp[1] = 1;

        // Calculate Fibonacci numbers from the 3rd to the nth
        for (int i = 2; i <= n; i++) {
            // Calculate the current Fibonacci number by adding the previous two
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        // Return the nth Fibonacci number
        return dp[n];
    }

    public static void main(String args[]) {
        int n = 5;
        // Calculate the nth Fibonacci number and print the result
        int result = calculateFibonacci(n);
        System.out.println(result);
    }

}
