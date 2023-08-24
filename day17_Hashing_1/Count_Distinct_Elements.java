package day17_Hashing_1;
/*
Given an array A of N integers, return the number of unique elements in the array.
 */
import java.util.ArrayList;
import java.util.HashSet;

public class Count_Distinct_Elements {
    public static int solve(ArrayList<Integer> A) {
        // Create a HashSet to store unique elements from the array
        HashSet<Integer> uniqueElementsSet = new HashSet<>();

        // Step 1: Add each element from the array to the HashSet
        for (int i = 0; i < A.size(); i++) {
            int currentElement = A.get(i);
            // HashSet automatically keeps only unique elements, duplicates will be ignored
            uniqueElementsSet.add(currentElement);
        }

        // Step 2: Return the number of unique elements in the array (size of the HashSet)
        return uniqueElementsSet.size();
    }

    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
        al.add(1);
        al.add(2);
        al.add(3);
        al.add(1);
        al.add(2);
        al.add(5);

        // Step 3: Call the solve method to find the number of unique elements
        System.out.println(solve(al)); // Output: 4 (4 unique elements: 1, 2, 3, 5)
    }
}
