package day13_Sorting;

import java.util.Arrays;

/*Given an integer array A, count the no of integers(p) in the array such that the number of integers greater than p
in the array equals to actual value p.
*/
public class NobleIntegerGreater {

    public static int solve(int[] A) {
        int n = A.length;
        int Great = 0;
        int count = 0;
//        Ascending Order
        Arrays.sort(A);
//        Reversing the array to get it in Descending Order according to the condition(Greater Element)
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
        }
//        Edge cases
        if (A[0] == 0) {
            count++;
        }
        for (int i = 1; i < n; i++) {
//            Unique Element (Checking if A[i] is occurring for the first time)
            if (A[i] != A[i - 1]) {
                Great = i;
            }
            if (A[i] == Great) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int a[] = {3, 2, 1, 3};
        System.out.println(solve(a));
    }
}
