package com.interfac;

public class InheriDemo
{

	public static void main(String[] args) 
	{	
		MountainBike mountainbike=new MountainBike(30, 20, 10);
		System.out.println("Gear is "+ mountainbike.getGear());
		System.out.println("Speed is "+mountainbike.getSpeed());
//		System.out.println("Seat height is "+mountainbike.seatheight);
		mountainbike.applybreak(1);
		mountainbike.speedup(5);
		System.out.println("speed after modifying is" +mountainbike.getSpeed());
		

	}

}
