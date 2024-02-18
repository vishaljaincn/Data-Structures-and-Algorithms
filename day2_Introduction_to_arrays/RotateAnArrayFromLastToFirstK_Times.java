package day2_Introduction_to_arrays;
//Google And Amazon

class RotateAnArrayFromLastToFirstK_Times {
    public void rotate(int[] arr, int k) {
        int n = arr.length;

        // Adjust k if it's greater than the array length
        if (k > n) {
            k = k % n;
        }

        // If k is equal to 0 or equal to the array length, no rotation needed
        if (n == k || k == 0) {
            return;
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

        // Reversing the first k elements
        i = 0;
        j = k - 1;
        while (i < j) {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }

        // Reversing the remaining elements after k
        i = k;
        j = n - 1;
        while (i < j) {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}
