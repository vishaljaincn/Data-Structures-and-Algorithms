package staticnestedclassdemo;

public class OuterClass
{
	static int outerstaticmem=10;
	public int mem=20;
	private static int outerprivatemem=30;
	static class StaticNestedClass
	{
		void display()
		{
			System.out.println(outerstaticmem);
//			System.out.println(mem);
			System.out.println(outerprivatemem);
		}
	}
}
