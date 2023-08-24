package day6_Introoduction_To_Arrays_2D_Matrices;

public class MainDiagonalSumOfN_cross_N_Matrix {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public static int solve(final int[][] A) {
        int n=A.length;
        int sum=0;
        for(int i=0;i<n;i++)
        {
            sum=sum+A[i][i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println(solve(matrix));
    }
}
