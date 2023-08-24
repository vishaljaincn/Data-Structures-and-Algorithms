/*
Given an integer array A of size N, find the first non-repeating element in it.

We need to find the element that occurs Exactly once and whose index of the first occurrence is the smallest.

If there is no non-repeating element, return -1
 */
package day17_Hashing_1;

import java.util.ArrayList;
import java.util.HashMap;

public class FindFirstNonRepeatingElement {
    public static int solve(ArrayList<Integer> A) {
        // Create a HashMap to store the frequency of elements in the array
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();

        // Step 1: Count the frequency of elements in the array A
        for (int i = 0; i < A.size(); i++) {
            int currentElement = A.get(i);
            // Increment the count for the current element or set it to 1 if not present
            if (frequencyMap.containsKey(currentElement)) {
                frequencyMap.put(currentElement, frequencyMap.get(currentElement) + 1);
            } else {
                frequencyMap.put(currentElement, 1);
            }
        }

        // Step 2: Find the first non-repeating element by iterating over the array and not hashmap,
        // because order of insertion is not maintained in hashmap.
        for (int i = 0; i < A.size(); i++) {
            int currentElement = A.get(i);
            // Check if the frequency of the current element is 1
            if (frequencyMap.get(currentElement) == 1) {
                // Return the first non-repeating element
                return currentElement;
            }
        }

        // Step 3: If no non-repeating element is found, return -1
        return -1;
    }

    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
        al.add(1);
        al.add(2);
        al.add(3);
        al.add(1);
        al.add(2);
        al.add(5);
        System.out.println(solve(al)); // Output: 3
    }
}
