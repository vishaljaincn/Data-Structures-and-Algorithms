package day36_Advanced_QuickSort_RadixSort;

import java.util.Arrays;

/*
Given an arrray A of N elements,and a subarray A[S,E] rearrange the Subarray such that A[S] should go to correct sorted position
and all the elments less than or equal toA[S] should go to left of A[S] and all the elments greater than A[S] should go to right of A[S]
 */
public class RearrangeSubArray {
    public static void rearrangeSubArray(int A[], int S, int E) {
        int pivot = A[S];
        int p1 = S + 1;
        int p2 = E;
        while (p1 <= p2) {
            if (A[p1] <= pivot) {
                p1++;
            } else if (A[p2] > pivot) {
                p2--;
            } else {
                int temp = A[p1];
                A[p1] = A[p2];
                A[p2] = temp;
                p1++;
                p2--;
            }
        }
        A[S] = A[p2];
        A[p2] = pivot;
    }

    public static void main(String[] args) {
        int A[] = {10, 3, 8, 15, 6, 12, 2, 18, 7, 15, 14};
        rearrangeSubArray(A, 2, 7); // Rearrange the array as described
        System.out.println(Arrays.toString(A)); // Print the rearranged array
    }
}
