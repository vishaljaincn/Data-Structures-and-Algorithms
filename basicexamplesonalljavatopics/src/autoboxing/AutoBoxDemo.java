package autoboxing;

import java.util.ArrayList;
import java.util.List;

public class AutoBoxDemo
{

	public static void main(String[] args)
	{
		int i=10;
		
//		auto-boxing
		Integer iobj=Integer.valueOf(i);
		System.out.println(iobj);
		
		Integer iobjInteger=10;
		System.out.println(iobjInteger);
		
//		un-boxing
		int i1=iobj;
		System.out.println(i1);
		
		char c='v';
		
//		auto-boxing
		Character cobj=Character.valueOf(c);
		System.out.println(cobj);
		
		Character cobjCharacter='v';
		System.out.println(cobjCharacter);
		
//		unboxing
		char c1=cobj;
		System.out.println(c1);
		
//		auto-boxing, adding the int primitive data type values to Integer List.
		List<Integer> list=new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		System.out.println(list);
	}

}
