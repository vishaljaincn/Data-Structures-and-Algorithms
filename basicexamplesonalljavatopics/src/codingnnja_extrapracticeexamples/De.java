package codingnnja_extrapracticeexamples;

import java.security.PublicKey;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.IntFunction;

public class De {
	public int fun(int a, int b)
	{
		if(b==0)
		{
			return a;
		}
		else
			return fun(b, a%b);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		De demDe=new De();
		int ans=demDe.fun(100,2000);
		System.out.println(ans);
		Optional<String>optional=Optional.of("hello");
		String string=optional.get();
		System.out.println(string);
	}

}
