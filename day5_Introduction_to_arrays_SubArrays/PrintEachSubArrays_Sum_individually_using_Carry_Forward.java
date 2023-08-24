package day5_Introduction_to_arrays_SubArrays;

public class PrintEachSubArrays_Sum_individually_using_Carry_Forward {
    public static void printEachSubArrays_Sum_individually_using_Carry_Forward(int arr[]) {
        int n = arr.length;
//        O(n^2)
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum = sum + arr[j];
                System.out.println(sum);
            }
        }
    }

    public static void main(String[] args) {
        int arr[]={1,2,3,4};
        printEachSubArrays_Sum_individually_using_Carry_Forward(arr);
    }
}
