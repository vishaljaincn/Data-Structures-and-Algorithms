package hashsetdemo;

import java.util.Collections;
import java.util.HashSet;

public class Hashsetdem {
	public static void main(String[]args)
	{
		HashSet<String> hs=new HashSet<>();
		hs.add("Ajay");
		hs.add("Bira");
		hs.add("Ciro");
		hs.add("Dagar");
		hs.add("Eshewar");
		
		System.out.println(hs);
		HashSet<String> set=new HashSet<String>();  
        set.add("Ravi");  
        set.add("Vijay");  
        set.add("Arun");  
        set.add("Sumit");  
        System.out.println(set); 
     
        
		hs.add("A");
		boolean r1=hs.add("C");
		boolean r2=hs.add("C");
		System.out.println(r1);
		System.out.println(r2);
		System.out.println(hs);
		System.out.println("Set contains C or not = "+ hs.contains("C"));
		hs.remove("A");
		System.out.println(hs);
		int a=hs.hashCode();
		System.out.println(a);
				
		for(String item:hs)
		{
			System.out.println(item);
		}
	}

}
