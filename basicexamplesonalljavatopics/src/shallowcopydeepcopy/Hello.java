package shallowcopydeepcopy;

public class Hello {
	int x, y;

	public void display() {
		System.out.println(x + " " + y);
	}

	public static void main(String[] args) {
		Hello hello = new Hello();
		hello.x = 15;
		hello.y = 25;
//		Shallow copy
		Hello hello2 = hello;
		hello.display();
		hello2.display();
		hello2.x=10;
		hello2.y=20; 
		hello.display();
		hello2.display();
//		Deep copy
		Hello hello3=new Hello();
		hello3.x=hello.x;
		hello3.y=hello.y;
		hello3.display();
		hello.x=10;
		hello.y=20;
		hello.display();
		hello3.display();
	}
}
