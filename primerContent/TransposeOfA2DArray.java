package primerContent;

import java.util.Arrays;

public class TransposeOfA2DArray {
    public static int[][]transpose(int[][] arr)
    {
        int rows=arr.length;
        int columns=arr[0].length;
        int[][]trans=new int[columns][rows];
        for(int i=0;i<columns;i++)
        {
            for(int j=0;j<rows;j++)
            {
                trans[i][j]=arr[j][i];
            }
        }
        return trans;
    }
    public static void justPrintTranspose(int[][] arr)
    {
        int rows=arr.length;
        int columns=arr[0].length;
        for(int i=0;i<columns;i++)
        {
            for(int j=0;j<rows;j++)
            {
                System.out.print(arr[j][i]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int [][]arr ={{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(Arrays.deepToString(transpose(arr)));
        justPrintTranspose(arr);
    }
}
