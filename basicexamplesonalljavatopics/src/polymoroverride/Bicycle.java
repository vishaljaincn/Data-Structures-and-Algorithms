package polymoroverride;

public class Bicycle 
{
	 int gear;
	 int speed;
	
	public Bicycle(int startspeed,int startgear)
	{
		gear=startgear;
		speed=startspeed;
	}
	
	public void applyBreak(int breakvalue)
	{
		speed-=breakvalue;
	}
	public void speedUp(int speedvalue)
	{
		speed+=speedvalue;
	}
	
	
	

}
