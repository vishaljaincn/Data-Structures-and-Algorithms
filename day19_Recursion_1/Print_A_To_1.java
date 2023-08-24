package day19_Recursion_1;

/*
You are given an integer A, print A to 1 using using recursion.

Note :- After printing all the numbers from A to 1, print a new line.
 */
public class Print_A_To_1 {
    // Main function to initiate the printing process
    public static void solve(int A) {
        printATo1(A); // Call the recursive function to print numbers from A to 1
        System.out.println(); // Print a new line after the sequence
    }

    // Recursive function to print numbers from A to 1
    public static void printATo1(int A) {
        // Base Condition: Stop the recursion when A is equal to 0
        if (A == 0) {
            return;
        }

        // Main Recursion logic:
        // Print the current value of A
        System.out.print(A + " ");
        // Recursively print numbers from A-1 to 1
        printATo1(A - 1);
    }

    public static void main(String[] args) {
        int A = 9; // Change this to the desired value of A
        solve(A); // Call the recursive function to print the sequence
    }
}
