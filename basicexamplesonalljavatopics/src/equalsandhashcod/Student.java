package equalsandhashcod;

public class Student
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
	public boolean equals(Object obj)
	{
		if(this==obj)
		{
			return true;		
		}
		if(obj==null || obj.getClass()!=this.getClass())
		{
			return false;
		}
		Student student=(Student)obj;
		
		return(student.rollno==this.rollno && student.name.equals(this.name));
		
	}
	
	public int hashcode()
	{
		return this.rollno;
	}
	
	public static void main(String[] args)
	{
		Student john=new Student(1, "john", "jainstreet,chamarajanagar");
		Student john2=new Student(1, "john", "Massachucets");
		Student john3=new Student(3, "johncena", "California");
		System.out.println(john.equals(john2));
		System.out.println(john.equals(john3));
		System.out.println(john.hashcode());
		System.out.println(john2.hashcode());
		System.out.println(john3.hashcode());
	}

}
