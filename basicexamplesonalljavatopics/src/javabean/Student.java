package javabean;

import java.io.Serializable;

//implementing serializable interface 
public class Student implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int rollno;
	private String name;
	private String address;

//	non-parameterised constructor
	public Student() {

	}
	
//	A Java Bean may have parameterized constructors, but they won't be used for the purposes that 
//	the original Java Beans specifications were intended to serve, so please avoid parameterized constructor

	public Student(int rollno, String name, String address) {
		this.rollno = rollno;
		this.name = name;
		this.address = address;
	}

//	getters and setters
	public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

}
