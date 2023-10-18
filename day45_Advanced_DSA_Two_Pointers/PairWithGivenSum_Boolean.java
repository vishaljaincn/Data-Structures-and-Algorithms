package day45_Advanced_DSA_Two_Pointers;

/*
Given an sorted integer array A of size N, and an integer K, check if there exists a pair(i,j) such that A[i]+A[j]=K, i!=j and
Space Complexity should be O(1)
 */
public class PairWithGivenSum_Boolean {
    // This method checks if there exists a pair of elements in the sorted array A[]
    // such that their sum equals the given integer K. It returns true if such a pair exists,
    // and false otherwise.
    public static boolean solve(int A[], int K) {
        int n = A.length;
        int i = 0; // Pointer at the beginning of the array
        int j = n - 1; // Pointer at the end of the array

        while (i < j) {
            if (A[i] + A[j] == K) {
                return true; // A pair with the sum K is found
            } else if (A[i] + A[j] < K) {
                i++; // Move the left pointer to the right
            } else {
                j--; // Move the right pointer to the left
            }
        }
        return false; // No such pair exists
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5}; // Example sorted array
        int targetSum = 9; // Target sum to find
        boolean result = solve(arr, targetSum);

        if (result) {
            System.out.println("There exists a pair with the sum " + targetSum);
        } else {
            System.out.println("There is no pair with the sum " + targetSum);
        }
    }
}

