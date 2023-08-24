package day17_Hashing_1;

import java.util.ArrayList;
import java.util.HashSet;

/*
Given an array of integers A, find and return whether the given array contains a non-empty sub array
with a sum equal to 0.

If the given array contains a sub-array with sum zero return 1, else return 0.
Problem Constraints
1 <= |A| <= 100000

-10^9 <= A[i] <= 10^9
 */
public class SubArrayWith_0_Sum_Check {
    public static int solve(ArrayList<Integer> A) {
        int n = A.size();
        ArrayList<Long> prefixSum = new ArrayList<>();
        prefixSum.add((long) A.get(0));
        // Step 1: Calculate cumulative sum for each index in the array
        // We update each element of the prefixSum array to store the cumulative sum from index 0 to that index.
        for (int i = 1; i < n; i++) {
            prefixSum.add(i, prefixSum.get(i - 1) + A.get(i));
        }

        // Step 2: Create a HashSet to store the cumulative sums encountered so far.
        // We use HashSet of Long type to handle large cumulative sums.
        HashSet<Long> hs = new HashSet<Long>();

        // Step 3: Traverse the array and check if any element is equal to 0,
        // which means there exists a sub-array with sum 0 from the beginning.
        // If such an element is found, return 1 immediately.
        for (int i = 0; i < n; i++) {
            long currentElement = prefixSum.get(i);
            if (currentElement == 0) {
                return 1;
            }

            // Step 4: Add the cumulative sum to the HashSet.
            hs.add(currentElement);
        }

        // Step 5: If there are duplicate cumulative sums in the HashSet, it means there exists a sub-array with sum 0.
        // Otherwise, there is no sub-array with sum 0.
        if (hs.size() < n) {
            return 1;
        }

        // If no sub-array with sum 0 is found, return 0.
        return 0;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        arr1.add(1);
        arr1.add(2);
        arr1.add(-3);
        arr1.add(3);
        System.out.println(solve(arr1));//output : 1
        ArrayList<Integer> arr4 = new ArrayList<>();
        arr4.add(1);
        arr4.add(2);
        arr4.add(3);
        System.out.println(solve(arr4));//output : 2
    }
}
