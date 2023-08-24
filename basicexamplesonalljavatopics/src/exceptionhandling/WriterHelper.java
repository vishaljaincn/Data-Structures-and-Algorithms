package exceptionhandling;

import java.util.ArrayList;
import java.util.List;

public class WriterHelper
{
	public void writeList()
	{
		try 
		{
			List<Integer> list=new ArrayList<>();
			list.add(10);
			System.out.println("Entering "+ "Try statement");
			int a=list.get(1);
			System.out.println("Accessing the first element : "+ a);
		} catch (IndexOutOfBoundsException e) 
		{
			// TODO: handle exception
			System.err.println(e.getMessage());
		}
		finally
		{
			System.out.println("this will always be executed");
		}
	}
	public static void main(String[]args)
	{
		WriterHelper writerHelper=new WriterHelper();
		writerHelper.writeList();
	}
}
