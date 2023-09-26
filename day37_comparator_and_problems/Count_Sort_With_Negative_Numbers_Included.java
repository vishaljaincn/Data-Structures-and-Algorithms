package day37_comparator_and_problems;

import java.util.Arrays;

public class Count_Sort_With_Negative_Numbers_Included {
    // Function to perform Counting Sort
    public static void countSort(int[] A) {
        // Find the length of the input array
        int n = A.length;

        // Find the minimum and maximum values in the input array
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, A[i]);
            max = Math.max(max, A[i]);
        }

        // Create a frequency array to store counts
        int freq[] = new int[max - min + 1];

        // Count the occurrences of each element and store in freq array
        for (int i = 0; i < n; i++) {
            freq[A[i] - min]++;
        }

        // Reconstruct the sorted array from the freq array
        int k = 0;
        for (int i = 0; i < freq.length; i++) {
            for (int j = 0; j < freq[i]; j++) {
                A[k] = i + min;
                k++;
            }
        }
    }

    public static void main(String[] args) {
        // Example input array with both positive and negative numbers
        int A[] = {-2, 3, 8, -5, 4, -2, 3};

        // Call the countSort function to sort the array
        countSort(A);

        // Print the sorted array
        System.out.println(Arrays.toString(A));
    }
}
