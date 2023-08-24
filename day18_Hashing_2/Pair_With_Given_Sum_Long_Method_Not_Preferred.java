package day18_Hashing_2;/*
Given an one-dimensional unsorted array A containing N integers.

You are also given an integer B, find if there exists a pair of elements in the array whose sum is B.

Return 1 if any such pair exists else return 0.
 */
import java.util.ArrayList;
import java.util.HashMap;

public class Pair_With_Given_Sum_Long_Method_Not_Preferred {
    public static int findPairWithSum(ArrayList<Integer> A, int B) {
        int K = B;
        int n = A.size();

        // Step 1: Create a frequency map to count occurrences of each element in the array
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int currentElement = A.get(i);
            if (frequencyMap.containsKey(currentElement)) {
                frequencyMap.put(currentElement, frequencyMap.get(currentElement) + 1);
            } else {
                frequencyMap.put(currentElement, 1);
            }
        }

        // Step 2: Check for pairs with the given sum
        for (int i = 0; i < n; i++) {
            int a = A.get(i);
            int b = K - a; // Calculate the potential complement

            // Case 1: If a and b are different and b is present in the frequencyMap
            if (a != b && frequencyMap.containsKey(b)) {
                return 1;
            }
            // Case 2: If a and b are the same and b appears more than once in the array
            else if (a == b && frequencyMap.get(a) > 1) {
                return 1;
            }
        }

        // If no such pair is found, return 0
        return 0;
    }

    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
        al.add(10);
        al.add(20);
        System.out.println(findPairWithSum(al, 10));
    }
}
