package primerContent;
//To Compute the sum of two matrices, the size(rows and columns) of two matrices must be same
public class SumOfTwoMatrices {
    public static void main(String[] args) {
       int arr1[][]={{1,2,3},{4,5,6}};
       int arr2[][]={{10,20,30},{40,50,60}};
       int arr3[][]=new int[arr1.length][arr1[0].length];
       for(int i=0;i<arr3.length;i++)
       {
           for(int j=0;j<arr3[0].length;j++)
           {
               arr3[i][j]=arr1[i][j]+arr2[i][j];
           }
           System.out.println();
       }
        for(int i=0;i<arr3.length;i++)
        {
            for(int j=0;j<arr3[0].length;j++)
            {
                System.out.print(arr3[i][j]+"  ");
            }
            System.out.println();
        }

    }
}
