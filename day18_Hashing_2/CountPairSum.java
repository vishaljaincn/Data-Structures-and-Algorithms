/*
You are given an array A of N integers and an integer B. Count the number of pairs (i,j) such that
A[i] + A[j] = B and i ≠ j.

Since the answer can be very large, return the remainder after dividing the count with 109+7.

Note - The pair (i,j) is same as the pair (j,i) and we need to count it only once.

*/
package day18_Hashing_2;

import java.util.ArrayList;
import java.util.HashMap;

public class CountPairSum {
    public int solve(ArrayList<Integer> A, int B) {
        // Get the size of the input array A
        int n = A.size();
        // Get the target sum B
        int k = B;
        // Create a HashMap to store the frequency of each element in the array
        HashMap<Integer, Integer> hm = new HashMap<>();
        // Define the constant for modulo operation
        final int mod = (int) (1e9 + 7);
        // Initialize a variable to count the number of pairs
        long count = 0;

        // Loop through the input array A
        for (int i = 0; i < n; i++) {
            // Get the value of the current element at index i
            int a = A.get(i);
            // Calculate the required value to form a pair with a sum of B
            int b = k - a;
            // If the HashMap contains the required value (b), then it forms a pair with a
            // Update the count by adding the frequency of the required value (b) in the HashMap
            // Note: We use modulo operation to avoid overflow
            if (hm.containsKey(b)) {
                count = (count + hm.get(b)) % mod;
            }
            // Increment the frequency of the current element in the HashMap
            hm.put(a, hm.getOrDefault(a, 0) + 1);
        }

        // Return the count of pairs after taking the modulo with the defined constant
        return (int) count % mod;
    }
}
