package primerContent;

import java.util.Scanner;

public class Sumof1toN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		int sum=0;
		for(int i=1;i<=n;i++)
		{
			int temp=scanner.nextInt();
			sum=sum+temp;
		}
		scanner.close();
		System.out.println(sum);
	}

}
