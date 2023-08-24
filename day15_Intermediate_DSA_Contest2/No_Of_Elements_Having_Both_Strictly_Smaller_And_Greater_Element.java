package day15_Intermediate_DSA_Contest2;

/*
Given an array of Integers A of size N, Find the count of Elements Having Both Strictly Smaller And Strictly
Greater Elements in the array

Constraints
1<=N<=10^5
1<=A[i]<=10^5
 */
public class No_Of_Elements_Having_Both_Strictly_Smaller_And_Greater_Element {
    public static int solve(final int[] A) {
        int n = A.length;
        int minimum = Integer.MAX_VALUE;
        int maximum = Integer.MIN_VALUE;

        // Find the minimum and maximum elements in the array
        for (int i = 0; i < n; i++) {
            if (A[i] < minimum) {
                minimum = A[i];
            }
            if (A[i] > maximum) {
                maximum = A[i];
            }
        }

        int count = 0;

        // Count elements that have both strictly smaller and strictly greater elements
        for (int i = 0; i < n; i++) {
            if (A[i] > minimum && A[i] < maximum) {
                count++;
            }
        }
        return count; // Return the count of elements that satisfy the condition
    }

    public static void main(String[] args) {
        int[] A1 = {1, 3, 1, 6};
        int[] A2 = {2, 1, 2, 9};
        System.out.println(solve(A1));
        System.out.println(solve(A2));
    }
}
