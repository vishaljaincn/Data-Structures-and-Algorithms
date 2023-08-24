package day17_Hashing_1;/*
Given two integer arrays, A and B of size N and M, respectively.
Your task is to find all the common elements in both the array.
NOTE:
Each element in the result should appear as many times as it appears in both arrays.
The result can be in any order.
 */

import java.util.ArrayList;
import java.util.HashMap;

public class CommonElementsInBothTheArray {
    public static ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        int n = A.size();
        // Create a HashMap to store the frequency of elements in the first array A
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();

        // Count the frequency of elements in array A
        for (int i = 0; i < n; i++) {
            int currentElement = A.get(i);
            if (frequencyMap.containsKey(currentElement)) {
                // If the element is already present in the HashMap,
                // increment its frequency by 1.
                frequencyMap.put(currentElement, frequencyMap.get(currentElement) + 1);
            } else {
                // If the element is not present in the HashMap,
                // add it with a frequency of 1.
                frequencyMap.put(currentElement, 1);
            }
        }

        // Create an ArrayList to store the common elements
        ArrayList<Integer> result = new ArrayList<>();
        int m = B.size();

        // Traverse through array B to find common elements
        for (int i = 0; i < m; i++) {
            int currentElement = B.get(i);
            if (frequencyMap.containsKey(currentElement) && frequencyMap.get(currentElement) > 0) {
                // If the element is present in the HashMap and its frequency is greater than zero,
                // add it to the result ArrayList and decrement its frequency in the HashMap.
                result.add(currentElement);
                frequencyMap.put(currentElement, frequencyMap.get(currentElement) - 1);
            }
        }

        // Return the ArrayList containing common elements
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A1 = new ArrayList<>();
        A1.add(1);
        A1.add(2);
        A1.add(2);
        A1.add(1);

        ArrayList<Integer> B1 = new ArrayList<>();
        B1.add(2);
        B1.add(3);
        B1.add(1);
        B1.add(2);
        System.out.println(solve(A1,B1));
    }
}
