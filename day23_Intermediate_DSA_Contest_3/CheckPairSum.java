package day23_Intermediate_DSA_Contest_3;/*
Given an Array of integers B, and a target sum A.
Check if there exists a pair (i,j) such that Bi + Bj = A and i!=j.
 */
import java.util.ArrayList;
import java.util.HashSet;

public class CheckPairSum {
    public static int solve(ArrayList<Integer> A, int B) {
        int k = B;
        int n = A.size();

        // Step 1: Create a HashSet to store the elements encountered in the array
        HashSet<Integer> hs = new HashSet<>();

        // Step 2: Traverse the array and check for pairs with the given sum
        for (int i = 0; i < n; i++) {
            // Get the current element "a"
            int a = A.get(i);

            // Calculate the potential complement "b"
            // "b" is the element we are looking for to form a pair with "a" with the given sum
            int b = k - a;

            // Case 1: If "b" is present in the HashSet "hs", it means we have found a pair
            // with the required sum "B"
            if (hs.contains(b)) {
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
