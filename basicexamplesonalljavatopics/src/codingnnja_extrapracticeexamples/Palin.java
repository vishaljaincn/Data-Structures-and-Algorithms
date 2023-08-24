package codingnnja_extrapracticeexamples;

public class Palin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a=1025611,temp,sum=0;
		int b=a;
		while(a!=0)
		{
			temp=a%10;
			sum=(sum*10)+temp;
			a=a/10;
		}
		System.out.println(sum);
		System.out.println(b);
		if(sum==b)
		{
			System.out.println("palindrome");
		}
		else {
			System.out.println("not palindrome");
		}
	}
	
	

}
