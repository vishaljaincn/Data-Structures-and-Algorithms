package com.inheri;

public class MountainBike extends Bicycle
{
	int seatheight;
	public MountainBike(int startspeed, int startgear,int startheight) 
	{
		super(startspeed, startgear);
		seatheight=startheight;
	}
	
	public void riseHeight(int heightValue)
	{
		seatheight-=heightValue;
	}
	
}
