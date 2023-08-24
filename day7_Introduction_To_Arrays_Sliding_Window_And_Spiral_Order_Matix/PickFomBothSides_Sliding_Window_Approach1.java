package day7_Introduction_To_Arrays_Sliding_Window_And_Spiral_Order_Matix;

/*
You are given an integer array A of size N.

You have to perform B operations. In one operation, you can remove either the leftmost or the rightmost element of the array A.

Find and return the maximum possible sum of the B elements that were removed after the B operations.

NOTE: Suppose B = 3, and array A contains 10 elements, then you can:

Remove 3 elements from front and 0 elements from the back, OR
Remove 2 elements from front and 1 element from the back, OR
Remove 1 element from front and 2 elements from the back, OR
Remove 0 elements from front and 3 elements from the back.
 */
public class PickFomBothSides_Sliding_Window_Approach1 {
    public static int solve(int[] A, int B) {
        int N = A.length;
        int leftSum = 0;
        int rightSum = 0;
        int maxRemovedSum = 0;

        // Calculate the sum of the leftmost B elements.
        for (int i = 0; i < B; i++) {
            leftSum = leftSum + A[i];
        }

        // Initialize the maximum removed sum with the leftmost B elements sum.
        maxRemovedSum = leftSum;

        int tempSum;

        // Sliding the window through the array to get the maximum removed sum.
        for (int i = 1; i <= B; i++) {
            leftSum = leftSum - A[B - i]; // Remove the element from the left window.
            rightSum = rightSum + A[N - i]; // Add the element to the right window.
            tempSum = leftSum + rightSum;
            maxRemovedSum = Math.max(maxRemovedSum, tempSum);
        }

        return maxRemovedSum;
    }

    public static void main(String[] args) {
        int arr[]={5, -2, 3 , 1, 2};
        System.out.println(solve(arr,3));
    }
}
