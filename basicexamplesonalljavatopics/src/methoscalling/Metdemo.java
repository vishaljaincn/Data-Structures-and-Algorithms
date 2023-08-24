package methoscalling;

public class Metdemo 
{
	private static void changeValue(int i)
	{
		i=i+1;
		System.out.println(i);
	}
	public static void main(String[]args)
	{
		int i=1;
		changeValue(i);
		System.out.println(i);
	}
}
