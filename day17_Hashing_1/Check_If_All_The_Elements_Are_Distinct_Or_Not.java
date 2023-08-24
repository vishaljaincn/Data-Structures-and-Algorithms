package day17_Hashing_1;
/*
Given an array A of N integers,check if all the elements are distinct or not, return 1 if all the elements are distinct
or else return 0 if all the elements are not distinct.
 */

import java.util.ArrayList;
import java.util.HashSet;

public class Check_If_All_The_Elements_Are_Distinct_Or_Not {
    public static int solve(ArrayList<Integer> A) {
        // Create a HashSet to store unique elements from the array
        HashSet<Integer> uniqueElementsSet = new HashSet<>();

        // Step 1: Add each element from the array to the HashSet
        for (int i = 0; i < A.size(); i++) {
            int currentElement = A.get(i);
            // HashSet automatically keeps only unique elements, duplicates will be ignored
            uniqueElementsSet.add(currentElement);
        }

        // Step 2: Check if the number of unique elements equals the size of the array
        // If they are equal, it means all elements are distinct, so return 1
        if (A.size() == uniqueElementsSet.size()) {
            return 1;
        }

        // Step 3: If the number of unique elements is less than the size of the array,
        // it means there are duplicate elements, so return 0
        return 0;
    }

    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
        al.add(1);
        al.add(2);
        al.add(3);
        al.add(11);
        al.add(22);
        al.add(3);

        // Step 4: Call the solve method to check if all elements are distinct or not
        System.out.println(solve(al)); // Output: 0 (There are duplicate elements: 3)
    }
}
