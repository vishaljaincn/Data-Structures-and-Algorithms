package day16_Strings;

/*
Given an array A. Sort this array using Count Sort Algorithm and return the sorted array.

Problem Constraints
1 <= |A| <= 105
1 <= A[i] <= 105
 */
public class CountSort {
    public static int[] solve(int[] A) {
        // Find the length of the input array
        int n = A.length;

        // Find the maximum element in the array
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (A[i] > max) {
                max = A[i];
            }
        }

        // Create a frequency array to store the count of occurrences of each element
        int[] frequency = new int[max + 1];
        for (int i = 0; i < n; i++) {
            int num = A[i];
            frequency[num] = frequency[num] + 1;
        }

        // Reconstruct the sorted array based on the frequency array
        int k = 0; // Position pointer for the sorted array A
        for (int i = 0; i < frequency.length; i++) {
            for (int j = 0; j < frequency[i]; j++) {
                A[k] = i; // Set the value of the element at position 'k' in the sorted array
                k++;
            }
        }

        return A; // Return the sorted array
    }

    public static void main(String[] args) {

    }
}
