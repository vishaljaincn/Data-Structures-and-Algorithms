package day2_Introduction_to_arrays;

public class CountTheNoOfElementsHavingAny1ElementGreaterThanItself {
    public static int countGreater(int[] arr) {
        int n = arr.length;
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == max) {
                count++;
            }
        }
        return n - count;
    }

    public static int aboveCodeUsingASingleLoop(int[] arr) {
        int n = arr.length;
        int max = arr[0];
        int count = 1;  // Initialize count to 1 since the first element is always counted

        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
                count = 1;  // Reset count to 1 whenever a new maximum element is found
            } else if (arr[i] == max) {
                count++;  // Increment count if the current element is equal to the current maximum
            }
        }

        return n - count;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 4, 6, 6};
        int[] arr2 = {4, 4, 4, 4, 1, 2, 3, 5, 6, 7};
        System.out.println(countGreater(arr));
        System.out.println(aboveCodeUsingASingleLoop(arr));
        System.out.println(countGreater(arr2));
        System.out.println(aboveCodeUsingASingleLoop(arr2));
    }
}

