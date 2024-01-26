package primerContent;

public class Basic {
    public int solve(int[] A, int[] B) {
        int n = A.length; // Number of elements in the array
        int min = Integer.MAX_VALUE; // Variable to store the final count of increasing triplets

        for (int i = 0; i < n; i++) {
            int mid=B[i];
            int left = (int)1e9; // Counter for elements smaller than A[i] on the left side
            int right = (int)1e9; // Counter for elements greater than A[i] on the right side

            // Count elements smaller than A[i] on the left side of A[i]
            for (int j = i - 1,k=i+1; j >= 0 && k<n; j--,k++) {
                if (A[j] < A[i]) {
                    left=A[j];
                }
                if (A[k] > A[i]) {
                    right=A[k];
                }
                min=Math.min(min,mid+left+right);
            }
        }

        return min; // Return the final count of increasing triplets
    }
}
