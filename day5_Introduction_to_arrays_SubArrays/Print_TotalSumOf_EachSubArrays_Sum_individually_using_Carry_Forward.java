package day5_Introduction_to_arrays_SubArrays;

public class Print_TotalSumOf_EachSubArrays_Sum_individually_using_Carry_Forward {
    public static void print_TotalSumOf_EachSubArrays_Sum_individually_using_Carry_Forward(int arr[]) {
        int n = arr.length;
        int totalSum=0;
//        O(n^2)
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum = sum + arr[j];
                totalSum=totalSum+sum;
                System.out.println(sum);
            }
        }
        System.out.println("Total Sum is " + totalSum);
    }

    public static void main(String[] args) {
        int arr[]={4,3,7};
        print_TotalSumOf_EachSubArrays_Sum_individually_using_Carry_Forward(arr);
    }
}
