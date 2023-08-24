package equalsandhashcod;

public class Maindem 
{

	public static void main(String[] args)
	{
		Student john=new Student(1, "john", "jainstreet,chamarajanagar");
		Student john2=new Student(1, "johnnybones", "jainstreet,chamarajanagar");
		Student john3=new Student(3, "johncena", "jainstreet,chamarajanagar");
		System.out.println(john.equals(john2));
		System.out.println(john.hashcode());
		System.out.println(john2.hashcode());
		System.out.println(john3.hashcode());
	}

}
