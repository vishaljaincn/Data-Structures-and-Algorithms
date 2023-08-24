package synchronisation;

public class SynchronisationDemo 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		MathUtils math=new MathUtils();
		Hello1 h1=new Hello1(math);
		Thread h2=new Thread(new Hello2(math));
		h1.start();
		h2.start();
	}

}
