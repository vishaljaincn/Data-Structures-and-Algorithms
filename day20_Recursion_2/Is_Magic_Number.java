package day20_Recursion_2;

/*
Given a number A, check if it is a magic number or not.

A number is said to be a magic number if the sum of its digits is calculated till a single digit recursively
by adding the sum of the digits after every addition. If the single digit comes out to be 1, then the number
is a magic number.
 */
public class Is_Magic_Number {
    // Function to check if a number is a magic number
    public static int solve(int A) {
        // Base case: If A is a single-digit number
        if (A < 10) {
            if (A == 1) {
                return 1; // A is a magic number
            } else {
                return 0; // A is not a magic number
            }
        }

        // Calculate the sum of digits recursively using the magic function
        return solve(magic(A)); // Recursively check the magic property of the sum of digits
    }

    // Function to calculate the sum of digits recursively
    public static int magic(int A) {
        // Base case: If A is 0, return 0
        if (A == 0) {
            return 0;
        }

        // Calculate the sum of the last digit and recursively sum of the rest of the digits
        return A % 10 + magic(A / 10); // Add last digit and call magic function on remaining digits
    }

    public static void main(String[] args) {
        System.out.println(solve(83557));
    }
}
