package day70_Advanced_DP_1_One_Dimensional;

class Fibonacci_Normal_Recursion {
    // Recursive implementation of Fibonacci sequence
    // Time Complexity: O(2^n) - Exponential
    // Space Complexity: O(n) - Recursive stack space

    // Method to calculate the nth Fibonacci number
    public static int fib(int n) {
        // Base case: if n is 0 or 1, return n
        if (n <= 1) {
            return n;
        }
        // Recursive case: sum of the previous two Fibonacci numbers
        return fib(n - 1) + fib(n - 2);
    }

    // Main method to demonstrate the Fibonacci function
    public static void main(String[] args) {
        // Example usage with n = 11
        int n = 11;
        System.out.println("Fibonacci of " + n + ": " + fib(n));
    }
}
