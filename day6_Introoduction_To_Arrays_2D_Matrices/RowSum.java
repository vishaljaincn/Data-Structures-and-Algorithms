package day6_Introoduction_To_Arrays_2D_Matrices;

import java.util.Arrays;

public class RowSum {
    public static int[] solve(int[][] A) {
        int n=A.length;
        int m=A[0].length;
        int []arr=new int[n];
        for(int i=0;i<n;i++)
        {
            int sum=0;
            for(int j=0;j<m;j++)
            {
                sum=sum+A[i][j];
            }
            arr[i]=sum;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[][] arr ={{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
        System.out.println(Arrays.toString(solve(arr)));
    }
}
