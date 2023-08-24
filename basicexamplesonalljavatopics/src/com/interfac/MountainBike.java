package com.interfac;

public class MountainBike implements Bicycle
{
	private int speed;
	private int gear;
	private int seatheight;

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public int getGear() {
		return gear;
	}

	public void setGear(int gear) {
		this.gear = gear;
	}

	public int getSeatheight() {
		return seatheight;
	}

	public void setSeatheight(int seatheight) {
		this.seatheight = seatheight;
	}

	public MountainBike(int startspeed, int startgear,int startheight) 
	{
		speed=startspeed;
		gear=startgear;
		seatheight=startheight;
	}

	@Override
	public void applybreak(int breakvalue) 
	{
		// TODO Auto-generated method stub
		speed=speed-breakvalue-10;
	}
	@Override
	public void speedup(int speedvalue) 
	{
		// TODO Auto-generated method stub
		speed=speed+speedvalue+10;
	}
	
	

	
	
}
