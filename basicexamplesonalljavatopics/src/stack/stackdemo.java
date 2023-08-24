package stack;

import java.util.Stack;

public class stackdemo {
	public static void main(String []args)
	{
		Stack<String> stack=new Stack<>();
		stack.push("America");
		stack.push("Germany");
		stack.push("India");
		System.out.println(stack.get(0));
		System.out.println(stack);
		String poppedelement=stack.pop();
		System.out.println(poppedelement);
		System.out.println(stack);
		String topelementString=stack.peek();
		System.out.println(topelementString);
		System.out.println(stack);
	}
}
