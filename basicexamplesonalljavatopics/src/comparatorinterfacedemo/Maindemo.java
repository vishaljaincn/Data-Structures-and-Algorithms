package comparatorinterfacedemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Maindemo 
{
	public static void main(String[] args)
	{
		Student john=new Student(1, "john", 47);
		Student john2=new Student(3, "tom", 35);
		Student john3=new Student(2, "airy", 42);
		List<Student> list=new ArrayList<>();
		list.add(john);
		list.add(john2);
		list.add(john3);
		
		
		Collections.sort(list, new AgeComparator());
		list.stream().forEach(x->System.out.println(x.getName()));
		list.stream().forEach(x->System.out.println("roll no is " +x.getRollno() + " name is "+x.getName() + " age is "+x.getAge()));
		
//		Collections.sort(list, new RollnoComparator());
		Collections.sort(list);
		list.stream().forEach(x->System.out.println(x.getName()));
		list.stream().forEach(x->System.out.println("roll no is " +x.getRollno() + " name is "+x.getName() + " age is "+x.getAge()));
		
		Collections.sort(list, new NameComparator());
		list.stream().forEach(x->System.out.println(x.getName()));
		list.stream().forEach(x->System.out.println("roll no is " +x.getRollno() + " name is "+x.getName() + " age is "+x.getAge()));
	}
}
