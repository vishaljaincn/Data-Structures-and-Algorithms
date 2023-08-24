package codingnnja_extrapracticeexamples;

import java.util.Arrays;
import java.util.Scanner;

public class InpArr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =new Scanner(System.in);
		System.out.println("enter no of rows");
		int n= sc.nextInt();
		System.out.println("enter no of colums");
		int m=sc.nextInt();
		int arr[][]=new int[n][m];
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				arr[i][j]=sc.nextInt();
				
			}
			System.out.println();
		}
//		for(int i=0;i<n;i++)
//		{
//			for(int j=0;j<m;j++)
//			{
//				System.out.print(arr[i][j]+" ");
//				
//			}
//			System.out.println();
//		}
		System.out.println(Arrays.deepToString(arr));
		
		
	}

}
