package day2_Introduction_to_arrays;

import java.util.Arrays;

public class RotateAnArrayFromFirst_To_Last_K_Times {
    public static int[] rotateAnArrayFromLastToFirstK_Times(int arr[], int k) {
        int n = arr.length;
        if (n == k || k == 0) {
            return arr;
        }
        if (k > n) {
            k = k % n;
        }

        // Reversing the entire array
        int temp;
        int j = n - 1;
        for (int i = 0; i < j; i++, j--) {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        // Reversing from 0 to n-k-1
        j = n - k - 1;
        for (int i = 0; i < j; i++, j--) {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        // Reversing from n-k to n-1
        int x = n - 1;
        for (int i = n - k; i < x; i++, x--) {
            temp = arr[i];
            arr[i] = arr[x];
            arr[x] = temp;
        }

        return arr;
    }

    public static void main(String[] args) {
        int arr[] = {3, -2, 1, 4, 6, 9, 8};
        System.out.println(Arrays.toString(rotateAnArrayFromLastToFirstK_Times(arr, 3)));
    }
}
