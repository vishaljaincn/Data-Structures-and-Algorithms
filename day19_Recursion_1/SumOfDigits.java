package day19_Recursion_1;

/*
Given a number A, we need to find the sum of its digits using recursion.
 */
public class SumOfDigits {
    // Recursive function to find the sum of digits of a number
    public static int solve(int A) {
        // Base case: Return A if it's a single-digit number
        if (A < 10) {
            return A;
        }

        // Main recursion logic:
        // Get the last digit of A (A % 10), and recursively find the sum of digits of the remaining number (A / 10)
        return A % 10 + solve(A / 10);
    }

    public static void main(String[] args) {
        System.out.println(solve(999));
    }
}
