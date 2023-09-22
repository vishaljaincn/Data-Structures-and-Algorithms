package day26_Advanced_Arrays_3_Interview_Problems;

import java.util.HashSet;

public class FirstMissingPositive_Using_HashSet {
    public static int firstMissingPositive(int[] A) {
        int n = A.length;

        // Create a hash set to store positive integers
        HashSet<Integer> positiveSet = new HashSet<>();

        // Step 2: Iterate through the array and add positive integers to the set
        for (int i = 0; i < n; i++) {
            if (A[i] > 0) {
                positiveSet.add(A[i]);
            }
        }

        // Step 3: Initialize the missing positive integer to 1
        int missing = 1;

        // Step 4: Check if missing is in the set and increment it until it's not
        while (positiveSet.contains(missing)) {
            missing++;
        }

        // Step 5: Return the first missing positive integer
        return missing;
    }

    public static void main(String[] args) {
        int[] array = {3, 4, -1, 1};
        int result = firstMissingPositive(array);
        System.out.println("The first missing positive integer is: " + result);
    }
}
