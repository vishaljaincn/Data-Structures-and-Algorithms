package calculatorapplication;

public class Subtract implements Operate
{

	@Override
	public Double getResult(Double... numbers) 
	{
		Double sub=numbers[0];
		for(int i=1;i<numbers.length;i++)
		{
			sub=sub-numbers[i];
		}
		return sub;
	}
	
}
