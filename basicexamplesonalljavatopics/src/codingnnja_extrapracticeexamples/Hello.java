package codingnnja_extrapracticeexamples;

public class Hello {
	int x, y;

	public void display() {
		System.out.println(x + " " + y);
	}

	public static void main(String[] args) {
		Hello hello = new Hello();
		hello.x = 15;
		hello.y = 25;
		hello.display();
//		Hello hello2 = hello;//shallow copy
//		hello.display();
//		hello2.display();
//		hello2.x=10;
//		hello2.y=20;
//		hello.display();
//		hello2.display();
		Hello hello3=new Hello();
		hello3.x=hello.x;
		hello3.y=hello.y;
		hello3.display();
		hello3.x=10;
		hello3.y=20;
		hello.display();
		hello3.display();
		
		
		String string=new String("hi");
		string.concat("hello");
		System.out.println(string);
	
	
	}
}
