package day20_Recursion_2;

/*
On the first row, we write a 0. Now in every subsequent row, we look at the previous row and replace
each occurrence of 0 with 01, and each occurrence of 1 with 10.

Given row number A and index B, return the Bth indexed symbol in row A. (The values of B are 0-indexed.).

Problem Constraints
1 <= A <= 20
0 <= B < 2A - 1
 */
public class Kth_Symbol_Easy {
    // This method calculates the Bth indexed symbol in the given row A.
    public static int solve(int A, int B) {
        // Base case: If A is 1, just return 0 itself.
        if (A == 1) {
            return 0;
        }
        // Calculate the middle index of the current row (A-1).
        int mid = (int) Math.pow(2, A - 1) / 2;


        // IF B IS 1-INDEXED, WE WOULD HAVE USED (B<=mid)
        if (B < mid) {
            // Recursively call solve for the previous row (A-1) and the same index B.
            return solve(A - 1, B);
        } else {
            // We negate the result of solve for the previous row (A-1) and index B-mid to swap 0s and 1s.
            return (1 - (solve(A - 1, B - mid)));
        }
    }

    public static void main(String[] args) {
        System.out.println(solve(5,11));
    }
}