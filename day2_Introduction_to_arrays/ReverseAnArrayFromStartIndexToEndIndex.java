package day2_Introduction_to_arrays;

import java.util.Arrays;

public class ReverseAnArrayFromStartIndexToEndIndex {
    public static int [] reverseAnArrayFromStartIndexToEndIndex(int arr[],int startIndex,int endIndex)
    {
        int temp;
        while(startIndex<endIndex)
        {
            temp=arr[startIndex];
            arr[startIndex]=arr[endIndex];
            arr[endIndex]=temp;
            startIndex++;
            endIndex--;
        }
        return arr;
    }
    public static int [] reverseAnArrayFromStartIndexToEndIndexUsingForLoop(int arr[],int startIndex,int endIndex)
    {
        int j=endIndex;
        int temp;
        for(int i=startIndex;i<j;i++,j--)
        {
            temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
        }
        return arr;
    }

    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6,7,8,9,10};
//        System.out.println(Arrays.toString(reverseAnArrayFromStartIndexToEndIndex(arr,3,9)));
        System.out.println(Arrays.toString(reverseAnArrayFromStartIndexToEndIndexUsingForLoop(arr,3,9)));
    }
}
