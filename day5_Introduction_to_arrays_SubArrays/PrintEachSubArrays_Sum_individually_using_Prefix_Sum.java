package day5_Introduction_to_arrays_SubArrays;

public class PrintEachSubArrays_Sum_individually_using_Prefix_Sum {
    public static void printEachSubArrays_Sum_individually_using_Prefix_Sum(int arr[]) {
        int n = arr.length;
//        Prefix Sum
        for (int i = 1; i < n; i++) {
            arr[i] = arr[i - 1] + arr[i];
        }
//        O(n^2)
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i == 0) {
                    System.out.println(arr[j]);
                } else {
                    System.out.println(arr[j] - arr[i - 1]);
                }
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4};
        printEachSubArrays_Sum_individually_using_Prefix_Sum(arr);
    }
}
