package day17_Hashing_1;
/*
Given an array A. You have some integers given in the array B.
For the i-th number, find the frequency of B[i] in the array A and return a list containing all the frequencies.
1 <= |A| <= 105
1 <= |B| <= 105
1 <= A[i] <= 105
1 <= B[i] <= 105
Input 1:
A = [1, 2, 1, 1]
B = [1, 2]
Input 2:
A = [2, 5, 9, 2, 8]
B = [3, 2]
Output 1:
[3, 1]
Output 2:
[0, 2]
 */

import java.util.ArrayList;
import java.util.HashMap;

public class Frequency_Of_Element_Query {

    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        // Create a HashMap to store the frequency of elements in array A
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();

        // Step 1: Count the frequency of elements in array A
        for (int i = 0; i < A.size(); i++) {
            int currentElement = A.get(i);
            // Increment the count for the current element or set it to 1 if not present
            if (frequencyMap.containsKey(currentElement)) {
                frequencyMap.put(currentElement, frequencyMap.get(currentElement) + 1);
            } else {
                frequencyMap.put(currentElement, 1);
            }
        }

        // Create a list to store the frequencies of elements in array B
        ArrayList<Integer> result = new ArrayList<>();

        // Step 2: Find the frequencies of elements in array B using the HashMap
        for (int i = 0; i < B.size(); i++) {
            int currentElement = B.get(i);
            // Check if the current element exists in the HashMap
            if (frequencyMap.containsKey(currentElement)) {
                // Add the frequency of the current element to the result list
                result.add(frequencyMap.get(currentElement));
            } else {
                // If the current element is not present in array A, add 0 to the result list
                result.add(0);
            }
        }

        // Step 3: Return the list containing frequencies of elements in array B
        return result;
    }
}
