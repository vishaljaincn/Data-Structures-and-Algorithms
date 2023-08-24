package synchronisation;

public class Hello1 extends Thread
{	
	MathUtils mu;
	public Hello1(MathUtils mu)
	{
		this.mu =mu;
	}
	public void run()
	{
		try
		{
			mu.getMultiples(2);
		} catch (Exception e)
		{
			// TODO: handle exception
			System.out.println(e);
		}
	}
}
