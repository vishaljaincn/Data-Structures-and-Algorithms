package generics;

public class DualGenericHolder<T,U>
{
	T obj1;
	U obj2;
	public DualGenericHolder(T obj1, U obj2)
	{
		this.obj1=obj1;
		this.obj2=obj2;
	}
	public void display()
	{
//		When u try to print the object inside System.out.println, 
//		by default the toString() method of the object will automatically be called.
		System.out.println(obj1);
		System.out.println(obj2);
	}
	public static void main(String[] args)
	{
		DualGenericHolder<String,Integer> dualGenericHolder=new DualGenericHolder<String, Integer>("Hello mofo", 100);
		dualGenericHolder.display();
		DualGenericHolder<Integer, String> dualGenericHolder2=new DualGenericHolder<Integer, String>(500, "Hi john");
		dualGenericHolder2.display();
	}

}
