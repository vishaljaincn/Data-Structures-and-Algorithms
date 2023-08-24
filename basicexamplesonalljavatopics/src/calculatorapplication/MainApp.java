package calculatorapplication;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MainApp 
{

	public static void main(String[] args) 
	{
		final String inputExpression=ReadInput.read();
		
		Queue<String> numbers;
		Queue<String> operations;		
		
		String numbersArray[]=inputExpression.split("[-+*/]");
		String operationsArray[]=inputExpression.split("[0-9]+");
		 
//		Converting an array into a list, then converting that list into an linked list
//		and the storing that linked list to a Queue
		numbers=new LinkedList<String>(Arrays.asList(numbersArray));
		operations=new LinkedList<String>(Arrays.asList(operationsArray));
		Double res=Double.parseDouble(numbers.poll());
		while(!numbers.isEmpty())
		{
			String opr=operations.poll();
			
			Operate operate;
			switch(opr)
			{
				case "+":
				{
					operate=new Add();
					break;
				}
				case "-":
				{
					operate=new Subtract();
					break;
				}
				case "*":
				{
					operate=new Multiply();
					break;
				}
				case "/":
				{
					operate=new Divide();
					break;
				}
				default:
				{
					continue;
				}
					
			}
			Double num=Double.parseDouble(numbers.poll());
			res = operate.getResult(res,num);
		}
		System.out.println(res);
	}

}
