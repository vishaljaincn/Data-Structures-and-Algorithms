package multithreading;

public class ExampleThread2 implements Runnable
{

	@Override
	public void run()
	{
		System.out.println("Thread 2 is running");		
	}
	
//	the runnable interface has only one method i.e, run(), below hello() method does not work
	public void hello()
	{
		System.out.println("hi");
	}

}
