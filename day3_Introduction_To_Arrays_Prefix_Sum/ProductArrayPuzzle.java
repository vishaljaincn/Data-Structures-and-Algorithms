package day3_Introduction_To_Arrays_Prefix_Sum;

import java.util.Arrays;
/*
Given an array of integers A, find and return the product array of the same size where the ith element
 of the product array will be equal to the product of all the elements divided by the ith element of the array.
Input Format

The only argument given is the integer array A.
Output Format

Return the product array.
Constraints

2 <= length of the array <= 1000
1 <= A[i] <= 10
For Example

Input 1:
    A = [1, 2, 3, 4, 5]
Output 1:
    [120, 60, 40, 30, 24]

Input 2:
    A = [5, 1, 10, 1]
Output 2:
    [10, 50, 5, 50]
 */
public class ProductArrayPuzzle {
    public static int[] solve(int[] A) {
        int n=A.length;
        int product=1;
        for(int i=0;i<n;i++)
        {
            product=product*A[i];
        }
        int B[]=new int [n];
        for(int i=0;i<n;i++)
        {
            int temp=product/A[i];
            B[i]=temp;
        }
        return B;
    }

    public static void main(String[] args) {
        int arr[]={1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(solve(arr)));
    }
}
