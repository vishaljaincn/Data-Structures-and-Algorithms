package day5_Introduction_to_arrays_SubArrays;

public class Print_TotalSum_of_All_Sub_array_Sums_Contribution_Technique {
    public static void print_TotalSum_of_All_Sub_array_Sums(int arr[])
    {
        int n=arr.length;
        int frequency,contribution,totalSum=0;
//        O(n)
        for(int i=0;i<n;i++)
        {
            frequency=(i+1)*(n-i);
            contribution=frequency*arr[i];
            totalSum=totalSum+contribution;
        }
        System.out.println(totalSum);
    }

    public static void main(String[] args) {
        int arr[]={4,3,7};
        print_TotalSum_of_All_Sub_array_Sums(arr);
    }
}
