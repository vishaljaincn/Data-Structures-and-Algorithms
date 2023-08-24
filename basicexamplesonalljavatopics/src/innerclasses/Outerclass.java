package innerclasses;

public class Outerclass 
{
//	public class InnerClass
//	{
//		void display()
//		{
//			System.out.println("this is a inner class method");
//		}
//	}
	public void outerclassmethod()
	{
		System.out.println("outer");
		class Methodlocalinnerclass
		{
			void localinnermethod()
			{
				System.out.println("method class");
			}
		}
		Methodlocalinnerclass object=new Methodlocalinnerclass();
		object.localinnermethod();
	}
}
