package day14_Interview_Problems;

/*
You are given an array A of N elements. Find the number of triplets i, j, and k
such that i < j < k and A[i] < A[j] < A[k].
*/
public class Count_Increasing_Triplets_O_N2 {
    // Function to find the number of increasing triplets in the given array A.
    public static int countIncreasingTriplets(int[] A) {
        int n = A.length; // Number of elements in the array
        int totalCount = 0; // Variable to store the final count of increasing triplets

        for (int i = 0; i < n; i++) {
            int leftSmaller = 0; // Counter for elements smaller than A[i] on the left side
            int rightGreater = 0; // Counter for elements greater than A[i] on the right side

            // Count elements smaller than A[i] on the left side of A[i]
            for (int j = i - 1; j >= 0; j--) {
                if (A[j] < A[i]) {
                    leftSmaller++;
                }
            }

            // Count elements greater than A[i] on the right side of A[i]
            for (int j = i + 1; j < n; j++) {
                if (A[j] > A[i]) {
                    rightGreater++;
                }
            }

            // The number of increasing triplets that can be formed with A[i] as the middle element
            int tripletsWithAI = leftSmaller * rightGreater;

            // Update the totalCount by adding the count of triplets with A[i] as the middle element
            totalCount = totalCount + tripletsWithAI;
        }

        return totalCount; // Return the final count of increasing triplets
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 4, 3};
        int result = countIncreasingTriplets(arr);
        System.out.println("Number of increasing triplets: " + result);
    }
}
