package serializationdeserialisation;

import java.io.Serializable;

public class Student implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int rollno;
	private String name;
	private String address;
	transient int x;
	
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
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ("student roll no is "+this.getRollno()+", student name is "+this.getName()+", student address is "+this.getAddress());
	}
	

}
