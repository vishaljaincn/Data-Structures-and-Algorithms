package synchronisation;

public class Hello2 implements Runnable
{
	MathUtils mu;
	
	public Hello2(MathUtils mu)
	{
		this.mu=mu;
	}

	@Override
	public void run() 
	{
		// TODO Auto-generated method stub
		try 
		{
			mu.getMultiples(3);
		} catch (Exception e)
		{
			// TODO: handle exception
			System.out.println(e);
		}
		
		
	}

}
