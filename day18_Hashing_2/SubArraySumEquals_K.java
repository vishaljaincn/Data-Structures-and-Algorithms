package day18_Hashing_2;

import java.util.ArrayList;
import java.util.HashMap;

/*
Given an array of integers A and an integer B.
Find the total number of sub arrays having sum equals to B.
 */
public class SubArraySumEquals_K {
    public static int solve(ArrayList<Integer> A, int B) {
        // Get the size of the ArrayList
        int n = A.size();

        // Create an ArrayList to store prefix sums
        ArrayList<Integer> ps = new ArrayList<>();

        // Calculate prefix sums
        ps.add(A.get(0));
        for (int i = 1; i < n; i++) {
            ps.add(ps.get(i - 1) + A.get(i));
        }

        // Create a HashMap to store prefix sums and their counts
        HashMap<Integer, Integer> map = new HashMap<>();

        // Initialize count to keep track of subarrays with sum equal to B
        int count = 0;

        // Traverse the prefix sums ArrayList and find subarrays with sum equal to B
        for (int i = 0; i < n; i++) {
            // If ps.get(i) - B is present in the HashMap, it means there exists a subarray
            // from some previous index "j" to the current index "i" whose sum is "B"
            if (map.containsKey(ps.get(i) - B)) {
                count += map.get(ps.get(i) - B);
            }

            // If ps.get(i) is equal to B, increment the count (special case for single-element subarray)
            // If we don't write special case for single-element subarray here, we can just add map.put(0,1) just after
            // creating a new HashMap.
            if (ps.get(i).equals(B)) {
                count++;
            }

            // Update the HashMap with the current prefix sum
            if (map.containsKey(ps.get(i))) {
                map.put(ps.get(i), map.get(ps.get(i)) + 1);
            } else {
                map.put(ps.get(i), 1);
            }
        }

        // Return the final count, which represents the number of contiguous subarrays
        // in the ArrayList "A" whose sum is equal to "B"
        return count;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(1);
        arr.add(1);
        arr.add(1);
        arr.add(1);
        int B = 2;

        int result = SubArraySumEquals_K.solve(arr, B);
        System.out.println("Number of sub arrays with sum equal to " + B + ": " + result); // Output: 4
    }
}
