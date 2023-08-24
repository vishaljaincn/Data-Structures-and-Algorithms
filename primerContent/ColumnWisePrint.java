package primerContent;
import java.util.Scanner;
public class ColumnWisePrint {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("enter no of rows");
        int rows= sc.nextInt();
        System.out.println("enter no of colums");
        int columns=sc.nextInt();
        int arr[][]=new int[rows][columns];
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<columns;j++)
            {
                arr[i][j]=sc.nextInt();

            }
            System.out.println();
        }
        for(int j=0;j<columns;j++)
        {
            for(int i=0;i<rows;i++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
