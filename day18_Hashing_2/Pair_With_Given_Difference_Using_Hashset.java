package day18_Hashing_2;

import java.util.ArrayList;
import java.util.HashSet;

/*
Given an one-dimensional unsorted array A containing N integers.

You are also given an integer B, find if there exists a pair of elements in the array whose difference is B.

Return 1 if any such pair exists else return 0.
 */
public class Pair_With_Given_Difference_Using_Hashset {
    public static int solve(ArrayList<Integer> A, int B) {
        int k = B;
        int n = A.size();

        // Step 1: Create a HashSet to store the elements encountered in the array
        HashSet<Integer> hs = new HashSet<>();

        // Step 2: Traverse the array and check for pairs with the given difference
        for (int i = 0; i < n; i++) {
            // Get the current element "a"
            int a = A.get(i);

            // Calculate the potential complements "b" and "b1"
            // "b" is the element we are looking for to form a pair with "a" with the given difference
            int b = k + a;
            // "b1" is the other element that forms a pair with "a" with the given difference
            int b1 = a - k;

            // Case 1: If "b" or "b1" is present in the HashSet "hs", it means we have found a pair
            // with the required difference "B"
            if (hs.contains(b) || hs.contains(b1)) {
                return 1;
            }

            // Add the current element "a" to the HashSet "hs" for future lookup
            hs.add(a);
        }

        // If no such pair is found, return 0
        return 0;
    }

    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
        al.add(10);
        al.add(20);
        System.out.println(solve(al, 10));
    }
}
