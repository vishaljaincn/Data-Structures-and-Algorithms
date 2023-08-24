package generics;

public class SingleGenericHolder<T>
{
	T obj;
	
	public SingleGenericHolder(T obj)
	{
		this.obj=obj;
	}
	
	public  T getObject()
	{
		return this.obj;
	}
	
	public static void main(String[] args) 
	{
		SingleGenericHolder<Integer> singleGenericHolder=new SingleGenericHolder<Integer>(10);
		System.out.println(singleGenericHolder.getObject());
		SingleGenericHolder<String> singleGenericHolder2=new SingleGenericHolder<String>("Hello");
		System.out.println(singleGenericHolder2.getObject());
	}
}
