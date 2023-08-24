package codingnnja_extrapracticeexamples;

public class Student
{
	String name;
	int age;
	String address;
	
	public Student(String name,int age, String address)
	{
		this.name=name;
		this.age=age;
		this.address=address;
	}
	public Student() {
		// TODO Auto-generated constructor stub
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

	public static void main(String[] args) 
	{
		Student john=new Student("john", 21,"jain street, near mahaveera bhavana, chamarajanagar");
//		Student john =new Student();
//		john.setName("johnscrictwit");
//		john.setAge(56);
//		john.setAddress("chuchungatte, saligrama, 560066");
		john.setName("vishal");
		System.out.println(john.getName());
		System.out.println(john.getAge());
		System.out.println(john.getAddress());
	}

}
