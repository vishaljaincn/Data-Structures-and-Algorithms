package day18_Hashing_2;
/*
You are given an array of N integers, A1, A2 ,..., AN and an integer B. Return the of count of distinct
numbers in all windows of size B.

Formally, return an array of size N-B+1 where i'th element in this array contains number of distinct
elements in sequence Ai, Ai+1 ,..., Ai+B-1.

NOTE: if B > N, return an empty array.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class DistinctNumbersInWindow {
    public static ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
        int N = A.size();
        HashMap<Integer, Integer> hm = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();
//        NOTE: if B > N, return an empty array.
        if (B > N) {
            return result;
        }

        // First Window
        for (int i = 0; i < B; i++) {
            int currentElement = A.get(i);
            if (hm.containsKey(currentElement)) {
                hm.put(currentElement, hm.get(currentElement) + 1);
            } else {
                hm.put(currentElement, 1);
            }
        }

        result.add(hm.size());

        // Remaining Windows
        for (int i = 1; i < N - B + 1; i++) {
            int previousElement = A.get(i - 1);
            int nextElement = A.get(i + B - 1);

            // Remove the count of the element that goes out of the window
            hm.put(previousElement, hm.get(previousElement) - 1);

            // If the count becomes zero, remove the element from the HashMap to keep it updated
            if (hm.get(previousElement) == 0) {
                hm.remove(previousElement);
            }

            // Add the count of the new element that comes into the window
            if (hm.containsKey(nextElement)) {
                hm.put(nextElement, hm.get(nextElement) + 1);
            } else {
                hm.put(nextElement, 1);
            }

            // Add the size of the current HashMap (count of distinct elements) to the result list
            result.add(hm.size());
        }

        return result;
    }

    public static void main(String[] args) {
        // Example Input
        ArrayList<Integer> A1 = new ArrayList<>(Arrays.asList(1, 2, 1, 3, 4, 3));
        int B1 = 3;

        ArrayList<Integer> A2 = new ArrayList<>(Arrays.asList(1, 1, 2, 2));
        int B2 = 1;

        // Example Output
        System.out.println(dNums(A1, B1)); // Output: [2, 3, 3, 2]
        System.out.println(dNums(A2, B2)); // Output: [1, 1, 1, 1]
    }
}
