package multithreading;

public class Demo
{

	public static void main(String[] args) throws InterruptedException 
	{
		for(int i=1;i<=10;i++)
		{
		Examplethread1 t1=new Examplethread1();
		t1.start();
		t1.hello();//works fine
//		t1.sleep(200); //this works fine as well
//		Thread.sleep(200);//best practice
		
		Thread t2=new Thread(new ExampleThread2());
		t2.start();
//		t2.hello();//does not work
//		t2.sleep(200); //this works fine as well
//		Thread.sleep(200);//best practice
		
		}
		
	}

}
