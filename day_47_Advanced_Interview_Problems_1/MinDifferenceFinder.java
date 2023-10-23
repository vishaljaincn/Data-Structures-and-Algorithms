package day_47_Advanced_Interview_Problems_1;
/*
 * Given 3 sorted arrays of size N, find i,j k such that max(A[i],B[j],C[k]) - min(A[i],B[j],C[k]) is minimum
 */
public class MinDifferenceFinder {
    public int[] findMinDifference(int[] A, int[] B, int[] C) {
        int i = 0, j = 0, k = 0;
        int minDiff = Integer.MAX_VALUE;
        int[] result = new int[3];

        // Iterate through the three sorted arrays A, B, and C to find the indices (i, j, k)
        // that minimize the difference between the maximum and minimum elements.

        while (i < A.length && j < B.length && k < C.length) {
            // Calculate the current difference for the current indices i, j, and k.
            int maxVal = Math.max(Math.max(A[i], B[j]), C[k]);
            int minVal = Math.min(Math.min(A[i], B[j]), C[k]);
            int currentDiff = maxVal - minVal;

            // Update minDiff and the result indices if the current difference is smaller.
            if (currentDiff < minDiff) {
                minDiff = currentDiff;
                result[0] = i;  // Store the index for array A
                result[1] = j;  // Store the index for array B
                result[2] = k;  // Store the index for array C
            }

            // Determine the array with the smallest element and increment the respective pointer.
            int minElem = Math.min(Math.min(A[i], B[j]), C[k]);
            if (A[i] == minElem) {
                i++;
            } else if (B[j] == minElem) {
                j++;
            } else {
                k++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        MinDifferenceFinder finder = new MinDifferenceFinder();

        int[] A = {1, 4, 7};
        int[] B = {2, 5, 8};
        int[] C = {3, 6, 9};

        // Find the indices (i, j, k) that minimize the difference and store the result.
        int[] result = finder.findMinDifference(A, B, C);

        System.out.println("Indices (i, j, k) that minimize the difference:");
        System.out.println("i: " + result[0] + ", j: " + result[1] + ", k: " + result[2]);
    }
}

