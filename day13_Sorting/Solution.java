package day13_Sorting;

import java.util.Arrays;

public class Solution {
    public int solve(int[] A) {
        int n = A.length;
        int greater = 0;
        int count = 0;
        Arrays.sort(A);
        // Reversing the array to get it in Descending Order
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
        }
        if (A[0] == 0) {
            return 1;
        }

        for (int i = 1; i < n; i++) {
            if (A[i] == i) {
                return 1;
            }
        }
        return -1;
    }
}
