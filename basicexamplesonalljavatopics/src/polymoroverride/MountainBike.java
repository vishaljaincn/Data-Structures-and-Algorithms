package polymoroverride;

public class MountainBike extends Bicycle
{
	int seatheight;
	public MountainBike(int startspeed, int startgear,int startheight) 
	{
		super(startspeed, startgear);
		seatheight=startheight;
	}
	public void applyBreak(int breakvalue)
	{
		speed=speed-breakvalue-10;
	}
	public void speedUp(int speedvalue)
	{
		speed=speed+speedvalue+10;
	}
	
	

	
	
}
