package day19_Recursion_1;

/*
You are given an integer A, print 1 to A using using recursion.

Note :- After printing all the numbers from 1 to A, print a new line.
 */
public class Print_1_To_A {
    // Main function to initiate the printing process
    public static void solve(int A) {
        print1ToA(A); // Call the recursive function to print numbers from 1 to A
        System.out.println(); // Print a new line after the sequence
    }

    // Recursive function to print numbers from 1 to A
    public static void print1ToA(int A) {
        // Base Condition: Stop the recursion when A is equal to 0
        if (A == 0) {
            return;
        }

        // Main Recursion logic:
        // Recursively print numbers from 1 to A-1
        print1ToA(A - 1);
        // Print the current value of A
        System.out.print(A + " ");
    }


    public static void main(String[] args) {
        int A = 9; // Change this to the desired value of A
        solve(A); // Call the recursive function to print the sequence
    }
}
