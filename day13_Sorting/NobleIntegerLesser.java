package day13_Sorting;

import java.util.Arrays;

/*Given an integer array A, count the no of integers(p) in the array such that the number of integers lesser than p
in the array equals to actual value p.
*/
public class NobleIntegerLesser {
    public static int solve(int[] A) {
        int n = A.length;
        int less = 0;
        int count = 0;
//        Ascending Order
        Arrays.sort(A);
//        Edge cases
        if (A[0] == 0) {
            count++;
        }
        for (int i = 1; i < n; i++) {
//        Unique Element (Checking if A[i] is occurring for the first time)
            if (A[i] != A[i - 1]) {
                less = i;
            }
            if (A[i] == less) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int a[] = {3, 2, 1, 3, 4, 4};
        System.out.println(solve(a));
    }
}
