package day15_Intermediate_DSA_Contest2;

/*
Given an array of Integers A of size N,How many elements in the array were divisible by 5 and have at least 2 strictly
smaller elements.

Note:Duplicate Elements are to be counted multiple times when finding the smaller elements

Constraints
1<=N<=10^5
1<=A[i]<=10^9
 */
public class Divisible_By_5_And_At_least_2_Strictly_Smaller_Elements {
    public static int solve(int[] A) {
        int n = A.length;

        // If the array has less than 3 elements, there can't be any element with at least 2 strictly smaller elements
        if (n < 3) {
            return 0;
        }

        int firstMinimum = Integer.MAX_VALUE;
        int secondMinimum = Integer.MAX_VALUE;

        // Find the first minimum element in the array
        for (int i = 0; i < n; i++) {
            if (A[i] < firstMinimum) {
                firstMinimum = A[i];
            } else if (A[i] < secondMinimum && A[i] >= firstMinimum) {
                secondMinimum = A[i];
            }
        }

        int count = 0;

        // Count elements that are divisible by 5 and have at least 2 strictly smaller elements
        for (int i = 0; i < n; i++) {
            if ((A[i] % 5 == 0) && (A[i] > firstMinimum) && (A[i] > secondMinimum)) {
                count++;
            }
        }

        return count; // Return the count of elements that satisfy the conditions
    }

    public static void main(String[] args) {
        int[] A1 = {10, 2, 6, 5};
        int[] A2 = {5, 5, 5, 10, 15, 20, 18};
        int[] A3 = {5, 5, 10};
        System.out.println(solve(A1));//1
        System.out.println(solve(A2));//3
        System.out.println(solve(A3));//1
    }
}
