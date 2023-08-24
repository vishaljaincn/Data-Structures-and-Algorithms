package day14_Interview_Problems;

/*
You are given an array A of N elements. Find the number of triplets i, j, and k
such that i < j < k and A[i] < A[j] < A[k].
*/
public class Count_Increasing_Triplets_O_N3 {
    // Function to find the number of increasing triplets in the given array A.
    public static int countIncreasingTriplets(int[] A) {
        int n = A.length; // Number of elements in the array
        int totalCount = 0; // Variable to store the final count of increasing triplets

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // Check if A[i] is less than A[j]
                if (A[i] < A[j]) {
                    for (int k = j + 1; k < n; k++) {
                        // Check if A[j] is less than A[k]
                        if (A[j] < A[k]) {
                            totalCount++; // Increment the count of increasing triplets
                        }
                    }
                }
            }
        }

        return totalCount; // Return the final count of increasing triplets
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 4, 3};
        int result = countIncreasingTriplets(arr);
        System.out.println("Number of increasing triplets: " + result);
    }
}
