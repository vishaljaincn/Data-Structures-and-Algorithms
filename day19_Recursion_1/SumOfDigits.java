package day19_Recursion_1;

/*
Given a number A, we need to find the sum of its digits using recursion.
 */
public class SumOfDigits {
    // Recursive function to find the sum of digits of a number
    public static int solve(int A) {
        // Base case: Return 0 if A is equal to 0
        if (A == 0) {
            return 0;
        }

        // Main recursion logic:
        // Get the last digit of A (A % 10), and recursively find the sum of digits of the remaining number (A / 10)
        return solve(A / 10) + A % 10;
    }

    public static void main(String[] args) {
        System.out.println(solve(999));
    }
}
