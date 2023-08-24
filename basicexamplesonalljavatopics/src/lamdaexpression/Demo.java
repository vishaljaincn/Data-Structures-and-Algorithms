package lamdaexpression;

public class Demo
{
	public static void main(String[] args) 
	{
//		Anonymous inner classes
//		A obj=new A() 
//		{		
//			@Override
//			public void show() 
//			{
//				System.out.println("Hi");	
//			}
//		};
//		obj.show();
		
		
		
		A obj=() ->System.out.println("Hi mofo");
//			{
//				System.out.println("Hi");
//				System.out.println("Hello");
//			};	
		obj.show();
	}
}
