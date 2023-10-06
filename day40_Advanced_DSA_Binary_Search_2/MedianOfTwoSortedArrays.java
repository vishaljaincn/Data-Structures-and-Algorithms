package day40_Advanced_DSA_Binary_Search_2;

public class MedianOfTwoSortedArrays {
    public static double findMedianSortedArrays(int[] A, int[] B) {
        // Find the sizes of the two input arrays
        int n1 = A.length;
        int n2 = B.length;

        // Calculate the total size of the merged array
        int n = n1 + n2;

        // Calculate the indices needed to find the median
        int ind2 = n / 2;
        int ind1 = ind2 - 1;
        int cnt = 0;
        int ind1Element = Integer.MIN_VALUE, ind2Element = Integer.MIN_VALUE;

        // Merge the sorted arrays A and B
        int i = 0, j = 0;
        while (i < n1 && j < n2) {
            if (A[i] <= B[j]) {
                if (cnt == ind1) ind1Element = A[i];
                if (cnt == ind2) ind2Element = A[i];
                cnt++;
                i++;
            } else {
                if (cnt == ind1) ind1Element = B[j];
                if (cnt == ind2) ind2Element = B[j];
                cnt++;
                j++;
            }
        }

        // Copy any remaining elements from A and B
        while (i < n1) {
            if (cnt == ind1) ind1Element = A[i];
            if (cnt == ind2) ind2Element = A[i];
            cnt++;
            i++;
        }
        while (j < n2) {
            if (cnt == ind1) ind1Element = B[j];
            if (cnt == ind2) ind2Element = B[j];
            cnt++;
            j++;
        }

        // Calculate and return the median based on the total size of the merged array
        if (n % 2 == 1) {
            return (double) ind2Element;
        }

        return (double) (ind1Element + ind2Element) / 2.0;
    }

    public static void main(String[] args) {
        int[] A = {1, 4, 7, 10, 12};
        int[] B = {2, 3, 6, 15};

        // Find and print the median of the two sorted arrays
        System.out.println("The median of two sorted arrays is " + findMedianSortedArrays(A, B));
    }
}
