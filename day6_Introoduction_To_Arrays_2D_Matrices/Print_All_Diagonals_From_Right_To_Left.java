package day6_Introoduction_To_Arrays_2D_Matrices;

public class Print_All_Diagonals_From_Right_To_Left {
    public static void print_All_Diagonals_From_Right_To_Left(int[][] A)
    {
        int n= A.length;
        int m=A[0].length;
        for(int c=0;c<m;c++)
        {
            int i=0,j=c;
            while(i<n && j>=0)
            {
                System.out.print(A[i][j]+" ");
                i++;j--;
            }
            System.out.println();
        }
        for(int r=1;r<n;r++)
        {
            int i=r,j=m-1;
            while (i<n && j>=0)
            {
                System.out.print(A[i][j]+" ");
                i++;j--;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] arr ={{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
        print_All_Diagonals_From_Right_To_Left(arr);
    }
}
