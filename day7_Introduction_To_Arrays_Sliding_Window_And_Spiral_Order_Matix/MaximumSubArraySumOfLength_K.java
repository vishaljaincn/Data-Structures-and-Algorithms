package day7_Introduction_To_Arrays_Sliding_Window_And_Spiral_Order_Matix;

/*
Given An Array of Length N, calculate Maximum subArray sum of length k
 */
public class MaximumSubArraySumOfLength_K {
    public static int solve(int A[], int k) {
        int n = A.length;
//        Calculating Sum Of First Window
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum = sum + A[i];
        }
        int ans = sum;
//        Sliding Window Approach
        int start = 1, end = k;
        while (end < n) {
            sum = sum - A[start - 1] + A[end];
            if (sum > ans) {
                ans = sum;
            }
            start++;
            end++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[]={3,4,-2,5,3,-2,8,2,1,4};
        System.out.println(solve(arr,6));
    }
}
