package day2_Introduction_to_arrays;

import java.util.Arrays;

public class RotateAnArrayFromFirst_To_Last_K_Times {

    // Function to rotate an array from last to first k times
    public static int[] rotateAnArrayFromLastToFirstK_Times(int arr[], int k) {
        int n = arr.length;

        // If k is equal to 0 or equal to the array length, no rotation needed
        if (n == k || k == 0) {
            return arr;
        }

        // Adjust k if it's greater than the array length
        if (k > n) {
            k = k % n;
        }

        // Reversing the entire array
        int temp;
        int i = 0;
        int j = n - 1;
        while (i < j) {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }

        // Reversing from 0 to n-k-1
        i = 0;
        j = n - k - 1;
        while (i < j) {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }

        // Reversing from n-k to n-1
        int x = n - 1;
        i = n - k;
        while (i < x) {
            temp = arr[i];
            arr[i] = arr[x];
            arr[x] = temp;
            i++;
            x--;
        }

        return arr;
    }

    // Main method to test the rotation function
    public static void main(String[] args) {
        int arr[] = {3, -2, 1, 4, 6, 9, 8};
        System.out.println(Arrays.toString(rotateAnArrayFromLastToFirstK_Times(arr, 3)));
    }
}
