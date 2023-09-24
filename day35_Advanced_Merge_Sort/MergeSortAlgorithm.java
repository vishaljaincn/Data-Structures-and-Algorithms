package day35_Advanced_Merge_Sort;

public class MergeSortAlgorithm {

    // Merge two subarrays A[start..mid] and A[mid+1..end] into A
    static void merge(int A[], int start, int mid, int end) {
        // Calculate the sizes of the two subarrays
        int n1 = mid - start + 1;
        int n2 = end - mid;

        // Create temporary arrays for the two subarrays
        int leftArray[] = new int[n1];
        int rightArray[] = new int[n2];

        // Copy data from A to the temporary arrays
        for (int i = 0; i < n1; i++)
            leftArray[i] = A[start + i];
        for (int j = 0; j < n2; j++)
            rightArray[j] = A[mid + 1 + j];

        // Copy data from A to the temporary arrays
       // System.arraycopy(A, start, leftArray, 0, n1);
       // System.arraycopy(A, mid + 1, rightArray, 0, n2);

        // Initialize indices for traversing leftArray, rightArray, and updating A
        int i, j, k;
        i = 0;
        j = 0;
        k = start;

        // Merge the two subarrays back into A in sorted order
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                A[k] = leftArray[i];
                i++;
            } else {
                A[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements from leftArray and rightArray back to A if any
        while (i < n1) {
            A[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            A[k] = rightArray[j];
            j++;
            k++;
        }
    }

    // Main function for sorting the array A using merge sort
    static void mergeSort(int A[], int start, int end) {
        // Check if there is more than one element in the array
        if (start < end) {
            // Find the middle index
            int mid = (start + end) / 2;

            // Recursively sort the left and right subarrays
            mergeSort(A, start, mid);
            mergeSort(A, mid + 1, end);

            // Merge the sorted subarrays
            merge(A, start, mid, end);
        }
    }

    public static void main(String args[]) {
        // Input array
        int arr[] = {6, 5, 12, 10, 9, 1};

        // Sort the array using merge sort
        mergeSort(arr, 0, arr.length - 1);

        // Print the sorted array
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
