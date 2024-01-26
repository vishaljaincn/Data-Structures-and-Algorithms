package day45_Advanced_DSA_Two_Pointers;
/*
Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]]
such that:
0 <= a, b, c, d < n
a, b, c, and d are distinct.
nums[a] + nums[b] + nums[c] + nums[d] == target
You may return the answer in any order.

Example 1:
Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

Example 2:
Input: nums = [2,2,2,2,2], target = 8
Output: [[2,2,2,2]]
 */
// Time complexity: O(n^3)
// Space complexity: O(1)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class FourSum_18 {
    public List<List<Integer>> fourSum(int[] A, int K) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = A.length;

        // Sorting the array to efficiently handle duplicates and to use the two-pointer technique
        Arrays.sort(A);

        // Fixing the first two elements of the quadruplet
        for (int i = 0; i < n - 3; i++) {
            // Skip duplicates for the first element
            if (i > 0 && A[i] == A[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < n - 2; j++) {
                // Skip duplicates for the second element
                if (j > i + 1 && A[j] == A[j - 1]) {
                    continue;
                }

                int x = j + 1; // Pointer for the third element
                int y = n - 1; // Pointer for the fourth element

                while (x < y) {
                    long sum = A[i];
                    sum += A[j];
                    sum += A[x];
                    sum += A[y];

                    if (sum == K) {
                        // Quadruplet found, add to the result list
                        List<Integer> temp = new ArrayList<>();
                        temp.add(A[i]);
                        temp.add(A[j]);
                        temp.add(A[x]);
                        temp.add(A[y]);
                        ans.add(temp);

                        x++;
                        y--;

                        // Skip duplicates for the third and fourth elements
                        while (x < y && A[x] == A[x - 1]) {
                            x++;
                        }
                        while (x < y && A[y] == A[y + 1]) {
                            y--;
                        }
                    } else if (sum < K) {
                        // Move the third pointer to the right
                        x++;
                    } else {
                        // Move the fourth pointer to the left
                        y--;
                    }
                }
            }
        }
        return ans;
    }
}
