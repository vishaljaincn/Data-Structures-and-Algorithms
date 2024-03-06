package day37_comparator_and_problems;


public class SelectionSortAlgorithm {

    // Function to perform selection sort on an array
    static void selectionSort(int arr[], int n) {
        for (int i = 0; i < n - 1; i++) {
            // Assume the current index is the minimum
            int minIndex = i;

            // Iterate through the unsorted part of the array to find the minimum element
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    // Update minIndex if a smaller element is found
                    minIndex = j;
                }
            }

            // Swap the found minimum element with the first element of the unsorted part
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }

        // Display the sorted array after selection sort
        System.out.println("After selection sort:");
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
        System.out.println("Before selection sort:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // Call the selectionSort function to sort the array
        selectionSort(arr, n);
    }
}
