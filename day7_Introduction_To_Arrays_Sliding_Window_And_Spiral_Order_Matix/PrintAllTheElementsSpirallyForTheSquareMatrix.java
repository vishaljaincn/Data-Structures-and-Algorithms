package day7_Introduction_To_Arrays_Sliding_Window_And_Spiral_Order_Matix;

public class PrintAllTheElementsSpirallyForTheSquareMatrix {
    public static void printAllTheElementsSpirallyForTheSquareMatrix(int A[][]) {
        int n = A.length;
        int i = 0, j = 0;
        while (n > 1) {
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
            i++;
            j++;
            n = n - 2;
        }
        if (n == 1) {
            System.out.println(A[i][j]);
        }
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3, 4, 5},
                {16, 17, 18, 19, 6},
                {15, 24, 25, 20, 7},
                {14, 23, 22, 21, 8,},
                {13, 12, 11, 10, 9}};
        printAllTheElementsSpirallyForTheSquareMatrix(arr);
        int[][] arr2 = {
                {1, 2, 3, 4},
                {16, 17, 18, 19},
                {15, 24, 25, 20},
                {14, 23, 22, 21},
        };
//        printAllTheElementsSpirallyForTheSquareMatrix(arr2);
    }
}
