package day19_Recursion_1;
/*
Write a program to find the factorial of the given number A using recursion.

Note: The factorial of a number N is defined as the product of the numbers from 1 to N.
 */
public class FindFactorial {
    // Recursive function to calculate the factorial of a number
    public static int fact(int A) {
        // Base Condition: Return 1 if A is 0 or 1 (Factorial of 0 is also 1)
        if (A == 0 || A == 1) {
            return 1;
        }
        // Main recursion logic: Calculate A! = A * (A-1)!
        return A * fact(A - 1);
    }

    public static void main(String[] args) {
        System.out.println(fact(5));
    }
}