package staticdemo;

public class Student
{
	static {
		System.out.println("initializer code");
	}
	String name;
	int age;
	String address;
	static String college="XYZ";
	static int currentnoofenrolledstudents=0;
	
	public Student(String name,int age, String address)
	{
		this.name=name;
		this.age=age;
		this.address=address;
		++currentnoofenrolledstudents;
		
	}
	public static int currentstudentcount()
	{
		return currentnoofenrolledstudents;
	}
	public void setName(String name)
	{
		this.name=name;
	}
	public void setAge(int age)
	{
		this.age=age;
	}
	public void setAddress(String address)
	{
		this.address=address;
	}
	public String getName()
	{
		return name;
	}
	public int getAge()
	{
		return age;
	}
	public String getAddress()
	{
		return address;
	}

	

}
