package day5_Introduction_to_arrays_SubArrays;

public class Print_The_Sum_Of_Sub_Arrays_From_Index_3 {
    public static void print_The_Sum_Of_Sub_Arrays_From_Index_3(int arr[])
    {
        int n=arr.length;
        int sum=0;
        for(int i=3;i<n;i++)
        {
            sum=sum+arr[i];
            System.out.println(sum);
        }
    }

    public static void main(String[] args) {
        int arr[]={5,6,7,1,2,3,4};
        print_The_Sum_Of_Sub_Arrays_From_Index_3(arr);
    }
}
