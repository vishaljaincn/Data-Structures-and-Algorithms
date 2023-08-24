package day17_Hashing_1;/*
Given an array A of N integers.

Find the count of the sub arrays in the array which sums to zero.
Since the answer can be very large, return the remainder on dividing the result with 109+7
 */

import java.util.ArrayList;
import java.util.HashMap;

public class Count_SubArray_Zero_Sum {
    public static int solve(ArrayList<Integer> A) {
        int n = A.size();
        int totalCount = 0;

        // Calculate the prefix sum and store it in 'pf' ArrayList
        ArrayList<Long> pf = new ArrayList<>();
        pf.add((long) A.get(0));
        for (int i = 1; i < n; i++) {
            pf.add((long) pf.get(i - 1) + A.get(i));
        }

        // Create a HashMap to store the count of each prefix sum
        HashMap<Long, Integer> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            long currentElement = pf.get(i);

            // Counting the total number of sub arrays with sum 0
            if (currentElement == 0) {
                totalCount++;
            }

            // Update the count of the current prefix sum in the HashMap
            if (hm.containsKey(currentElement)) {
                hm.put(currentElement, hm.get(currentElement) + 1);
            } else {
                hm.put(currentElement, 1);
            }
        }

        // Count the total number of sub arrays with the same sum
        for (int count : hm.values()) {
            if (count >= 2) {
                totalCount = totalCount + ((count * (count - 1)) / 2);
            }
        }

        return totalCount;
    }

    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>();
        input.add(2);
        input.add(3);
        input.add(-4);
        input.add(4);
        input.add(-4);
        System.out.println(solve(input));//output : 2
    }
}
