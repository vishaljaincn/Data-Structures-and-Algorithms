package day2_Introduction_to_arrays;
//Google And Amazon
import java.util.Arrays;

public class RotateAnArrayFromLastToFirstK_Times {
    public static int [] rotateAnArrayFromLastToFirstK_Times(int arr[],int k)
    {
        int n = arr.length;
        if (k > n) {
            k = k % n;
        }
        if (n == k||k==0) {
            return arr;
        }

        // Reversing the entire array
        int temp;
        int j = n - 1;
        for (int i = 0; i < j; i++, j--) {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        // Reversing the first k elements
        j = k - 1;
        for (int i = 0; i < j; i++, j--) {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        // Reversing the remaining elements after k
        int x = n - 1;
        for (int i = k; i < x; i++, x--) {
            temp = arr[i];
            arr[i] = arr[x];
            arr[x] = temp;
        }

        return arr;
    }

    public static void main(String[] args) {
        int arr[]={3,-2,1,4,6,9,8};
        System.out.println(Arrays.toString(rotateAnArrayFromLastToFirstK_Times(arr,3)));
    }
}
