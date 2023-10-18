package day45_Advanced_DSA_Two_Pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.
 */
public class ThreeSum_Q_No_15_LeetCode {
    public static List<List<Integer>> threeSum(int[] A) {
        // Sort the input array in ascending order
        Arrays.sort(A);

        // Initialize a list to store the result
        List<List<Integer>> result = new ArrayList<>();

        // Get the length of the input array
        int n = A.length;

        // Iterate through the array to find triplets
        for (int i = 0; i < n - 2; i++) {
            // Skip duplicate elements by checking if the current element is the same as the previous
            if (i != 0 && A[i] == A[i - 1]) {
                continue;
            }

            // Initialize two pointers, j and k, for the remaining part of the array
            int j = i + 1;
            int k = n - 1;

            // Use a while loop to find triplets
            while (j < k) {
                int sum = A[i] + A[j] + A[k];
                if (sum < 0) {
                    // If the sum is less than 0, it means we need to increase the sum, so move the left pointer (j) to the right
                    j++;
                } else if (sum > 0) {
                    // If the sum is greater than 0, it means we need to decrease the sum, so move the right pointer (k) to the left
                    k--;
                } else {
                    // If the sum is 0, it's a valid triplet; add it to the result list
                    List<Integer> temp = new ArrayList<>();
                    temp.add(A[i]);
                    temp.add(A[j]);
                    temp.add(A[k]);
                    result.add(temp);

                    // Move both pointers, and skip duplicate elements
                    j++;
                    k--;
                    while (j < k && A[j] == A[j - 1]) {
                        j++;
                    }
                    while (j < k && A[k] == A[k + 1]) {
                        k--;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // Example usage:
        int[] inputArray = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> triplets = threeSum(inputArray);

        System.out.println("Triplets that sum to zero:");
        for (List<Integer> triplet : triplets) {
            System.out.println(triplet);
        }
    }
}