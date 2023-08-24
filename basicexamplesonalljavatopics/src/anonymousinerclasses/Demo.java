package anonymousinerclasses;

public class Demo {

	public static void main(String args[])
	{
		Eatble person=new Person();
		person.eat();
		Eatble eatble=new Eatble() {
			
			@Override
			public void eat() {
				// TODO Auto-generated method stub
				System.out.println("a person can eat");
			}
		};
		eatble.eat();
		Eatble eatble2=new Eatble() {
			
			@Override
			public void eat() {
				// TODO Auto-generated method stub
				System.out.println("no one can eat shit");
			}
		};
		eatble2.eat();
		
	}
}
