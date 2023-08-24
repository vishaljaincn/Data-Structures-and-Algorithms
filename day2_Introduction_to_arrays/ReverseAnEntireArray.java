package day2_Introduction_to_arrays;

import java.util.Arrays;

public class ReverseAnEntireArray {
    public static int [] reverseEntireArray(int arr[])
    {
        int i=0;
        int j=arr.length-1;
        int temp;
        while (i<j)
        {
            temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
        return arr;
    }

    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6};
        System.out.println(Arrays.toString(reverseEntireArray(arr)));
//      Printing all the elements of an array
        for(int i:arr)
        {
            System.out.println(i);
        }
    }
}
