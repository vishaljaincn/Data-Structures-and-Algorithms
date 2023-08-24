package codingnnja_extrapracticeexamples;
 
import java.util.Scanner;
public class Solution {
	public static int fact(int n)
	{
		int i=1,fact=1;
		while(i<=n)
		{
			fact =fact*i;
			i++;
		}
		return fact;
		
	}
	public static int ncr(int a, int b)
	{
		int factn,factr,factnr;
		factn=fact(a);
		factr=fact(b);
		factnr=fact(a-b);
		int result=factn/(factr*factnr);
		return result;
	}
	public static void main(String[] args)
	{
			Scanner sc = new Scanner(System.in); 
			int n = sc.nextInt();
			int c=sc.nextInt();
			int res =ncr(n, c);
			System.out.println(res);
		
		
	}
	    
	    
}
  