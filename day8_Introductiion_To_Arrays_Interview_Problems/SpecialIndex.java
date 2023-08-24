package day8_Introductiion_To_Arrays_Interview_Problems;

/*
Given an array, arr[] of size N, the task is to find the count of array indices such that removing
an element from these indices makes the sum of even-indexed and odd-indexed array elements equal.
 */
public class SpecialIndex {
    public static int solve(int[] A) {
        int n = A.length;
        // Array with a Single Element: If the input array A contains only one element,
        // you can handle it by returning 0 as there are no valid indices to calculate the sum.
        if (n <= 1) {
            return 0;
        }
        // Creating a new Prefix Sum Array to store Sum of only Even Indices
        int PfEven[] = new int[n];
        PfEven[0] = A[0];
        for (int i = 1; i < n; i++) {
            if (i % 2 == 0) {
                PfEven[i] = PfEven[i - 1] + A[i];
            } else {
                PfEven[i] = PfEven[i - 1];
            }
        }
        // Creating a new Prefix Sum Array to store Sum of only Odd Indices
        int PfOdd[] = new int[n];
        PfOdd[0] = 0;

        for (int i = 1; i < n; i++) {
            if (i % 2 == 1) {
                PfOdd[i] = PfOdd[i - 1] + A[i];
            } else {
                PfOdd[i] = PfOdd[i - 1];
            }
        }
        int SumEven, SumOdd, count = 0;

        for (int i = 0; i < n; i++) {
            // Edge cases
            if (i == 0) {
                SumEven = PfOdd[n - 1] - PfOdd[i];
                SumOdd = PfEven[n - 1] - PfEven[i];
            } else {
                SumEven = PfEven[i - 1] + (PfOdd[n - 1] - PfOdd[i]);
                SumOdd = PfOdd[i - 1] + (PfEven[n - 1] - PfEven[i]);
            }
            if (SumEven == SumOdd) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] A = {2, 1, 6, 4};
        System.out.println(solve(A));

    }
}
