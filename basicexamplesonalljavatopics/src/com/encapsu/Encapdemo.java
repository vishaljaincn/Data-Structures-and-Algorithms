package com.encapsu;

public class Encapdemo
{
	public static void main(String[] args) 
	{
		Student john=new Student(21, "john","jain street, near mahaveera bhavana, chamarajanagar");
		System.out.println(john);
		System.out.println(john.getRollno());
		System.out.println(john.getName());
		System.out.println(john.getAddress());
	
//		john.name="vishal";
//		System.out.println(john.name);
		john.setName("vishal");
		System.out.println(john.getName());
		
		
		
	}
}
