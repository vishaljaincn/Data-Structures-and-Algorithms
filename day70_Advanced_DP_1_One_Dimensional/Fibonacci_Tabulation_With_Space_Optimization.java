package day70_Advanced_DP_1_One_Dimensional;
/*
Time Complexity: O(N)

Reason: We are running a simple iterative loop

Space Complexity: O(1)

Reason: We are not using any extra space
 */

public class Fibonacci_Tabulation_With_Space_Optimization {

    // Method to calculate the nth Fibonacci number using iteration
    public static int fib(int n) {
        // Base case: if n is 0 or 1, return n
        if (n <= 1) {
            return n;
        }

        // Initialize variables to store the previous two Fibonacci numbers and the current Fibonacci number
        int prevPrev = 0;  // Fibonacci number at position n-2
        int prev = 1;      // Fibonacci number at position n-1
        int current = 0;   // Fibonacci number at position n

        // Iterate from position 2 to n to calculate Fibonacci numbers iteratively
        for (int i = 2; i <= n; i++) {
            current = prev + prevPrev;  // Calculate the current Fibonacci number
            prevPrev = prev;            // Update the previous Fibonacci number at position n-2
            prev = current;             // Update the previous Fibonacci number at position n-1
        }

        // Return the calculated Fibonacci number at position n
        return current;
    }

    // Main method to test the fib() method
    public static void main(String[] args) {
        // Test case: calculate and print the 11th Fibonacci number
        int n = 11;
        System.out.println("Fibonacci of " + n + ": " + fib(n));
    }
}
