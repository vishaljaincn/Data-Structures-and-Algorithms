package com.encapsu;

public class Student {
	private int rollno;
//  String name;
	private String name;
	private String address;

	public Student() {

	}

//	@Override
//	public String toString() {
//		return "Student [rollno=" + rollno + ", name=" + name + ", address=" + address + "]";
//	}

	public Student(int rollno, String name, String address) {
		this.rollno = rollno;
		this.name = name;
		this.address = address;
	}

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
