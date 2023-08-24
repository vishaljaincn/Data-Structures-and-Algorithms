package recursion;

public class RecursionDemo
{
	int factorial(int n)
	{
		if(n==1)
		{
			return 1;
		}
		else
		{
			return (n*factorial(n-1));
		}
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
		RecursionDemo recursionDemo=new RecursionDemo();
		int fact=recursionDemo.factorial(5);
		System.out.println(fact);
	}

}
