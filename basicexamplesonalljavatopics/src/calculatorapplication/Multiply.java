package calculatorapplication;

public class Multiply implements Operate
{

	@Override
	public Double getResult(Double... numbers)
	{
		Double mul=1.0;
		for(Double num:numbers)
		{
			mul=mul*num;
		}
		return mul;
	}
	
}
