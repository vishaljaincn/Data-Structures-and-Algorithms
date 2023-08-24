package treeset;

import java.util.Set;
import java.util.TreeSet;

public class Treesetdemo {

	public static void main(String[]args)
	{
		TreeSet<String> ts=new TreeSet<>();
		ts.add("C");
		ts.add("B");
		ts.add("C");//rejects duplicate elements
		ts.add("A");
		System.out.println(ts);//by default the tree set sorts the elements in ascending order.
		Set<String> set=new TreeSet<String>();  
        set.add("Ravi");  
        set.add("Vijay");  
        set.add("Arun");  
        set.add("Sumit");  
        System.out.println(set);
       
	}
}
