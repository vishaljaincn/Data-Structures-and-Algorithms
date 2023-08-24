package day7_Introduction_To_Arrays_Sliding_Window_And_Spiral_Order_Matix;

public class PrintBoundaryOfSquareMatrixInClockWiseDirection {
    public static void printBoundaryOfSquareMatrixInClockWiseDirection(int A[][]) {
        int n = A.length;
        int i = 0, j = 0;
//        Printing From Left To Right
        for (int k = 0; k < n - 1; k++) {
            System.out.print(A[i][j]);
            j++;
        }
        System.out.println();
        //        Printing From Top To Bottom

        for (int k = 0; k < n - 1; k++) {
            System.out.print(A[i][j]);
            i++;
        }
        System.out.println();
        //        Printing From Right To Left

        for (int k = 0; k < n - 1; k++) {
            System.out.print(A[i][j]);
            j--;
        }
        System.out.println();
        //        Printing From Bottom to Top
        for (int k = 0; k < n - 1; k++) {
            System.out.print(A[i][j]);
            i--;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[][] = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        printBoundaryOfSquareMatrixInClockWiseDirection(arr);
    }
}
