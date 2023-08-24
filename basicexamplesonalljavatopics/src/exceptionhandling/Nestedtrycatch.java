package exceptionhandling;

public class Nestedtrycatch 
{

	public static void main(String[] args) 
	{
		try 
		{	
			try 
			{
				try 
				{
					int arr[]= {1,2,3,4};
					System.out.println(arr[10]);
				}
				catch (ArrayIndexOutOfBoundsException e)
				{
					System.err.println(e.getMessage());
					throw e;
				}
			}
			catch (ArrayIndexOutOfBoundsException e)
			{
				System.err.println(e.getMessage());
				throw e;
			}
		}
		catch (ArrayIndexOutOfBoundsException e) 
		{
			System.err.println(e.getMessage());
		}
	}		
}
		

