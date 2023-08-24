package synchronisation;

public class MathUtils {
	synchronized void getMultiples(int n) {
//		synchronized (this) 
//		{
		for (int i = 1; i <= 5; i++) {
			System.out.println(n * i);
			try {
				Thread.sleep(40);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}
		}
//		}
	}

}
