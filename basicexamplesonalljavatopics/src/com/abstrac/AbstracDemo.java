package com.abstrac;

public class AbstracDemo 
{
	public static void main(String args[])
	{
		GraphicObject circle= new Circle();
		circle.draw();
		circle.resize();
		circle.moveTo(20, 10);
		GraphicObject rectangle=new Rectangle();
		rectangle.draw();
		rectangle.resize();
		rectangle.moveTo(10, 20);
		Square square=new Square();
		square.draw();
		square.resize();
		square.moveTo(30, 20);
		square.hello();
	}
}
