package calculatorapplication;

public interface Operate 
{
//	... -> var-arg array(Variable Argument array), here num is a vararg array of arbitrary length(variable length)
	Double getResult(Double... num);
}
