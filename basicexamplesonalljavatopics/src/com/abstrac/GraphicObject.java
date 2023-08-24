package com.abstrac;

public abstract class GraphicObject 
{
	void moveTo(int x,int y)
	{
		System.out.println("move to x "+x +" y " +y);
	}
	abstract void draw();
	abstract void resize();
}
