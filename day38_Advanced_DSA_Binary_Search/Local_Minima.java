package day38_Advanced_DSA_Binary_Search;

public class Local_Minima {
    public static int findLocalMinima(int[] A) {
        int n = A.length;

        // Base case: If there's only one element, it's the unique answer.
        if (n == 1)
            return A[0];

        // Check if the first element is the answer.
        if (A[0] < A[1])
            return A[0];

        // Check if the last element is the answer.
        if (A[n - 1] < A[n - 2])
            return A[n - 1];

        int low = 1;
        int high = n - 2;

        // Perform binary search to find the local minima.
        while (low <= high) {
            int mid = (low + high) / 2;

            // If the current element is less than its neighbors, it's the local minima.
            if (A[mid] < A[mid - 1] && A[mid] < A[mid + 1])
                return A[mid];
                // If the current element is greater than its left neighbor but less than its right neighbor,
                // move the search to the right half of the array.
            else if (A[mid] < A[mid - 1])
                low = mid + 1;
                // Otherwise, move the search to the left half of the array.
            else
                high = mid - 1;
        }

        return -1; // If no local minima is found, return -1.
    }

    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 3, 6, 4, 1, 5, 2, 10, -4};
        int result = findLocalMinima(arr);
        if (result != -1) {
            System.out.println("Local Minima: " + result);
        } else {
            System.out.println("No Local Minima found.");
        }
    }
}
