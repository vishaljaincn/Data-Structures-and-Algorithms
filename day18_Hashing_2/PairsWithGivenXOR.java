package day18_Hashing_2;

import java.util.ArrayList;
import java.util.HashSet;

/*
Given an integer array A containing N distinct integers.

Find the number of unique pairs of integers in the array whose XOR is equal to B.

NOTE:

Pair (a, b) and (b, a) is considered to be the same and should be counted once.
 */
public class PairsWithGivenXOR {
    public static int solve(ArrayList<Integer> A, int B) {
        // Store the value of B in the variable k
        int k = B;
        // Get the size of the ArrayList A
        int n = A.size();
        // Create a HashSet(HASHMAP IS NOT REQUIRED BECAUSE ALL THE ELEMENTS IN THE ARRAY ARE DISTINCT
        // AS GIVEN IN THE PROBLEM STATEMENT to store the encountered elements of A
        HashSet<Integer> hs = new HashSet<>();
        // Initialize the count of pairs with XOR equal to B to 0
        int count = 0;

        // Loop through each element of the ArrayList A
        for (int i = 0; i < n; i++) {
            // Get the current element a
            int a = A.get(i);
            // Calculate the XOR of a and B, store it in variable b
            int b = a ^ k;

            // Check if the HashSet hs contains the value b
            // If yes, it means we have found a pair (a, b) with XOR equal to B
            // Increment the count by 1
            if (hs.contains(b)) {
                count++;
            }

            // Add the current element a to the HashSet hs
            // If a is already in the HashSet, it won't be added again (no duplicates in a HashSet)
            hs.add(a);
        }

        // Return the count of pairs with XOR equal to B
        return count;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        arr1.add(5);
        arr1.add(4);
        arr1.add(10);
        arr1.add(15);
        arr1.add(7);
        arr1.add(6);
        int B1 = 5;
        System.out.println(solve(arr1,B1));// Output: 1

        ArrayList<Integer> arr2 = new ArrayList<>();
        arr2.add(3);
        arr2.add(6);
        arr2.add(8);
        arr2.add(10);
        arr2.add(15);
        arr2.add(50);
        int B2 = 5;
        System.out.println(solve(arr2,B2));// Output: 2
    }
}
