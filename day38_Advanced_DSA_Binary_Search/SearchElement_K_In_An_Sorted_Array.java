package day38_Advanced_DSA_Binary_Search;

public class SearchElement_K_In_An_Sorted_Array {
    // Binary search method to find the index of element k in a sorted array A
    public static int binarySearch(int A[], int k) {
        int n = A.length;
        int low = 0;
        int high = n - 1;

        // Repeat the binary search until low is less than or equal to high
        while (low <= high) {
            int mid = (low + high) / 2; // Calculate the middle index

            if (A[mid] == k) {
                return mid; // Element found, return its index
            } else if (A[mid] < k) {
                low = mid + 1; // Adjust the search range to the right half
            } else {
                high = mid - 1; // Adjust the search range to the left half
            }
        }

        return -1; // Element not found
    }

    public static void main(String[] args) {
        // Sample sorted array
        int[] sortedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // Element to search for
        int targetElement = 6;
        int targetElement2 = 12;
        // Call binarySearch to find the index of targetElement
        int resultIndex = binarySearch(sortedArray, targetElement);
        int resultIndex2 = binarySearch(sortedArray, targetElement2);

        // Check if the element was found and print the result
        if (resultIndex != -1) {
            System.out.println("Element " + targetElement + " found at index " + resultIndex);
        } else {
            System.out.println("Element " + targetElement + " not found in the array.");
        }
        if (resultIndex2 != -1) {
            System.out.println("Element " + targetElement + " found at index " + resultIndex);
        } else {
            System.out.println("Element " + targetElement + " not found in the array.");
        }
    }
}
