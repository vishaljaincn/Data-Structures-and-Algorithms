package com.inheri;

public class InheriDemo
{

	public static void main(String[] args) 
	{
		MountainBike mountainBike=new MountainBike(20, 10, 3);
		System.out.println("Speed is "+mountainBike.speed);
		System.out.println("Gear is "+ mountainBike.gear);
		System.out.println("Seat height is "+mountainBike.seatheight);
		mountainBike.applyBreak(1);
		System.out.println(mountainBike.speed);
		mountainBike.riseHeight(1);
		System.out.println(mountainBike.seatheight);
		
		
		

	}

}
