package day37_comparator_and_problems;

public class BubbleSortAlgorithm {

    // Function to perform bubble sort on an array
    static void bubbleSort(int[] arr, int n) {
        // Outer loop for the number of passes
        for (int i = n - 1; i >= 0; i--) {
            // Inner loop for each pass
            for (int j = 0; j <= i - 1; j++) {
                // Compare adjacent elements and swap them if they are in the wrong order
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        // Display the sorted array after bubble sort
        System.out.println("After bubble sort: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        // Example array
        int arr[] = {13, 46, 24, 52, 20, 9};
        int n = arr.length;

        // Display the original array before sorting
        System.out.println("Before using Bubble Sort: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // Call the bubbleSort function to sort the array
        bubbleSort(arr, n);
    }
}
