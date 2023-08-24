package day10_Introduction_To_Bit_Manipulation_1;
/*
Given an array of integers A, every element appears twice except for one. Find that integer that occurs once.

NOTE: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class UniqueElement {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public static int singleNumber(final int[] A) {
        int n=A.length;
        int ans=0;
        // TC - O(n)     SC - O(1)
        // XOR all the elements in the array, you'll get the unique element
        for(int i=0;i<n;i++)
        {
            ans=ans^A[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[]={1, 2, 2, 3, 1};
        System.out.println(singleNumber(arr));
    }
}
