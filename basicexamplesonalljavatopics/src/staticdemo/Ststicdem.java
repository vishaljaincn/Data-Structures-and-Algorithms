package staticdemo;

public class Ststicdem
{
	public static void main(String args[])
	{
		Student s1=new Student("vishal", 20, "jain street");
		System.out.println(s1.getName());
		System.out.println(s1.getAge());
		System.out.println(s1.getAddress());
		System.out.println(Student.college);
		Student s2 =new Student("varun",21,"lowda street");
		System.out.println(s2.getName());
		System.out.println(s2.getAge());
		System.out.println(s2.getAddress());
		System.out.println(Student.college);
		System.out.println(Student.currentstudentcount());
		System.out.println(Student.currentnoofenrolledstudents);
	}
}
