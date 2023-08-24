package day13_Sorting;

import java.util.Arrays;

/*
Given an integer array A of size N. You can remove any element from the array in one operation.
The cost of this operation is the sum of all elements in the array present before this operation.

Find the minimum cost to remove all elements from the array.
 */
public class ElementRemoval {
    public static int solve(int[] A) {
        int n = A.length;
        int cost = 0;
        // Inbuilt sort method which sorts in ascending order and TC - O(N logN)
        Arrays.sort(A);
        // Reversing the array to get it in Descending Order
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
        }
        for (int i = 0; i < n; i++) {
            cost = cost + A[i] * (i + 1);
        }
        return cost;

        ////////////////////////////////////////////////////////////////

        // Only with ascending order sorting we can solve this problem

        // int n = A.length;
        // int cost=0;
        // Arrays.sort(A);
        // for(int i=0;i<n;i++)
        // {
        //    cost = cost+A[i]*(n-i);
        // }
        // return cost;
    }

    public static void main(String[] args) {
        int arr[]={2, 1};
        System.out.println(solve(arr));
    }
}
