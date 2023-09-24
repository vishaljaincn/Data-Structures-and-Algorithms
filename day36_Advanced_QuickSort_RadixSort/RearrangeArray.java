package day36_Advanced_QuickSort_RadixSort;
/*
Given an arrray A of N elements, rearrange the array such that A[0] should go to correct sorted position and all the
elments less than or equal toA[0] should go to left of A[0] and all the elments greater than A[0] should go to right of A[0]
 */

import java.util.Arrays;

public class RearrangeArray {
    // Function to rearrange the array as described
    public static void rearrange(int A[]) {
        int n = A.length;
        int pivot = A[0]; // Choose the first element as the pivot
        int p1 = 1; // Pointer for elements less than or equal to pivot
        int p2 = n - 1; // Pointer for elements greater than pivot

        while (p1 <= p2) {
            if (A[p1] <= pivot) {
                p1++; // Move the p1 pointer to the right
            } else if (A[p2] > pivot) {
                p2--; // Move the p2 pointer to the left
            } else {
                // Swap elements at p1 and p2 if THEY ARE UNHAPPY
                int temp = A[p1];
                A[p1] = A[p2];
                A[p2] = temp;
                p1++;
                p2--;
            }
        }

        // Swap the pivot (A[0]) with the element at p2
        A[0] = A[p2];
        A[p2] = pivot;
    }

    public static void main(String[] args) {
        int A[] = {10, 3, 8, 15, 6, 12, 2, 18, 7, 15, 14};
        rearrange(A); // Rearrange the array as described
        System.out.println(Arrays.toString(A)); // Print the rearranged array
    }
}
