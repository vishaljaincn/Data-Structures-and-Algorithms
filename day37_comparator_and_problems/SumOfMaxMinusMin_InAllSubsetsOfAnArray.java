
package day37_comparator_and_problems;

import java.util.Arrays;

/*
Find the sum of (Max-Min) for all the Subsets of an Array
 */
public class SumOfMaxMinusMin_InAllSubsetsOfAnArray {
    // Function to calculate the sum of (Max-Min) for all subsets of an array
    public static int sumOfMaxMin(int A[]) {
        int n = A.length;
        Arrays.sort(A); // Sort the input array in ascending order
        int max = 0; // Initialize the sum of (Max-Min)

        for (int i = 0; i < n; i++) {
            // Calculate the contribution of the current element to the sum
            //We can use this, but below bit manipulation one is much faster
            //max += A[i] * ((int) (Math.pow(2, i)) - (int) (Math.pow(2, n - 1 - i)));
            max += A[i] * ((1 << i) - (1 << n - 1 - i));
        }
        return max; // Return the sum of (Max-Min) for all subsets
    }

    public static void main(String[] args) {
        int A[] = {3, 2, 5};
        System.out.println(sumOfMaxMin(A)); // Output will be the sum of (Max-Min) for all subsets
    }
}
