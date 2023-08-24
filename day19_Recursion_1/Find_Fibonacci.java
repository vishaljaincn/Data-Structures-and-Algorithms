package day19_Recursion_1;
/*
The Fibonacci numbers are the numbers in the following integer sequence.

0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ……..

In mathematical terms, the sequence Fn of Fibonacci numbers is defined by the recurrence relation:

Fn = Fn-1 + Fn-2

Given a number A, find and return the Ath Fibonacci Number using recursion.

Given that F0 = 0 and F1 = 1
//////////////////////////////////TC - O(2^N)   SC - O(N)
 */
public class Find_Fibonacci {
    // Recursive function to find the A-th Fibonacci number
    public static int findAthFibonacci(int A) {
        // Base condition: Return A if it's 0 or 1
        if (A <= 1) {
            return A;
        }
        // Main Recursion logic: Find (A-1)-th and (A-2)-th Fibonacci numbers
        return findAthFibonacci(A - 1) + findAthFibonacci(A - 2);
    }

    public static void main(String[] args) {
        System.out.println(findAthFibonacci(10));
    }
}
