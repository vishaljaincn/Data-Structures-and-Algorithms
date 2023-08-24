package calculatorapplication;

import java.util.Scanner;

public class ReadInput 
{
	public static String read()
	{
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter Input Expression [For ex : 4*4+2]");
		String inputExpresion=scanner.nextLine();
		scanner.close();
		return inputExpresion;
	}
}
