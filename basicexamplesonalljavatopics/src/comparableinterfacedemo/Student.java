package comparableinterfacedemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Student implements Comparable<Student>
{
	private int rollno;
	private String name;
	private String address;
	public Student(int rollno, String name, String address)
	{
		this.rollno=rollno;
		this.name=name;
		this.address=address;
	}
	public int getRollno() 
	{
		return rollno;
	}
	public void setRollno(int rollno)
	{
		this.rollno = rollno;
	}
	public void setName(String name)
	{
		this.name=name;
	}
	public void setAddress(String address)
	{
		this.address=address;
	}
	public String getName()
	{
		return name;
	}
	public String getAddress()
	{
		return address;
	}
	@Override
	public int compareTo(Student student) {
		// TODO Auto-generated method stub
		return this.rollno-student.rollno;
//		return this.name.compareTo(student.name);
	}
	public static void main(String[] args)
	{
		Student john=new Student(3, "john", "jainstreet");
		Student john2=new Student(1, "dohnnybones", "california");
		Student john3=new Student(2, "aohncena", "massachucets");
		List<Student> list=new ArrayList<>();
		list.add(john);
		list.add(john2);
		list.add(john3);
		Collections.sort(list);
		list.stream().forEach(x->System.out.println(x.getName()));
		list.stream().forEach(x->System.out.println("roll no is " +x.getRollno() + " name is "+x.getName() + " address is "+x.getAddress()));
		
		
		

	}
	

}
