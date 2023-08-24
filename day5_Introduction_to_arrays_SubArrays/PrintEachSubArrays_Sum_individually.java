package day5_Introduction_to_arrays_SubArrays;

public class PrintEachSubArrays_Sum_individually {
    public static void printEachSubArrays_Sum_individually(int arr[]) {
        int n = arr.length;
//        O(n^3)
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum = sum + arr[k];
                }
                System.out.println(sum);
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4};
        printEachSubArrays_Sum_individually(arr);
    }
}
