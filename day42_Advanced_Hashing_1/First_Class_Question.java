package day42_Advanced_Hashing_1;

import java.util.Arrays;
import java.util.HashMap;

/*
given an integer array A, find a pair (i,j)index such that A[i]==A[j] and |i-j| is maximum
Distance between two indices is defined as |i-j|
 */
public class First_Class_Question {
    public static int[] solve(int A[]) {
        int n = A.length;
        int ans = Integer.MIN_VALUE;  // Initialize the maximum difference to the minimum integer value.
        int left = -1;  // Initialize the left index of the pair.
        int right = -1;  // Initialize the right index of the pair.
        int result[] = new int[2];  // Create an array to store the result indices.
        HashMap<Integer, Integer> hm = new HashMap<>();  // Create a HashMap to store elements and their indices.

        for (int i = 0; i < n; i++) {
            int curElement = A[i];  // Get the current element from the array.

            if (hm.containsKey(curElement)) {  // If the element is already in the HashMap.
                int diff = Math.abs(hm.get(curElement) - i);  // Calculate the absolute difference between the current and stored index.

                if (diff > ans) {  // If the current difference is greater than the maximum difference found so far.
                    ans = diff;  // Update the maximum difference.
                    left = hm.get(curElement);  // Update the left index of the pair.
                    right = i;  // Update the right index of the pair.
                }
            } else {  // If the element is not in the HashMap.
                hm.put(curElement, i);  // Put the element in the HashMap with its index.
            }
        }
        System.out.println("MaxLength is " + ans);  // Print the maximum length (maximum difference).
        result[0] = left;  // Store the left index in the result array.
        result[1] = right;  // Store the right index in the result array.
        return result;  // Return the result array containing the indices of the pair.
    }

    public static void main(String[] args) {
        int A[] = {1, 2, 3, 4, 1, 3, 5, 1, 5, 2};
        System.out.println(Arrays.toString(solve(A)));  // Call the solve method and print the result.
    }
}
