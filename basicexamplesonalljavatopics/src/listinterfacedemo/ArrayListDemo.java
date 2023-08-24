package listinterfacedemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListDemo 
{

	public static void main(String[] args)
	{
		 List<Integer> arraylist=new ArrayList<>(5);
		 List<Integer>arraylistIntegers=new ArrayList<>();		 
		 List<String> astrings=new ArrayList<>();
		 astrings.add("D");
		 astrings.add("A");
		 astrings.add("C");
		 astrings.add("X");
		 astrings.add("Y");
		 astrings.add("B");
		 System.out.println(astrings.get(0));
		 Collections.sort(astrings);
		 System.out.println(astrings);
		 astrings.remove("F");
		 astrings.remove(3);
		 System.out.println(astrings.get(0));
		 
//		 adding elements to arraylist
		 for(int i=5;i>0;i--)
		 {
			 arraylist.add(i);
		 }
		 System.out.println(arraylist);
		 Collections.sort(arraylist);
		 System.out.println(arraylist);
		 System.out.println(arraylist.size());
		 System.out.println(arraylist.get(0));
		 for(int i=1;i<=5;i++)
		 {
			 arraylistIntegers.add(i);
		 }
		
		
		 
		 //printing the arraylist
		 System.out.println(arraylist);
		 System.out.println(arraylistIntegers);
		 System.out.println(arraylist.equals(arraylistIntegers));
		 System.out.println(arraylist.hashCode());
		 System.out.println(arraylistIntegers.hashCode());
		 
		 //remove element at index 3
		 arraylist.remove(3);
		 
		 //printing the arraylist after removing an element
		 System.out.println(arraylist);
		 
		 //printing elements one by one
		 for(int i=0;i<arraylist.size();i++)
		 {
			 System.out.print(arraylist.get(i)+" ");
		 }
		 
		 System.out.println();
		 
		 //printing elements one by one using enhanced each loop - easiest way
		 for(int i:arraylist)
		 {
			 System.out.print(i+" ");
		 } 
		 System.out.println("\n"+arraylist.get(0));

	}

}
