package polymoroverride;

public class InheriDemo
{

	public static void main(String[] args) 
	{
		
		Bicycle bicycle=new Bicycle(20, 10);
		System.out.println("Gear is "+ bicycle.gear);
		System.out.println("Speed is "+bicycle.speed);
//		System.out.println("Seat height is "+bicycle.seatheight);
		bicycle.applyBreak(1);
		System.out.println("speed after modifying is" +bicycle.speed);
		Bicycle mountainbike=new MountainBike(30, 20, 10);
		System.out.println("Gear is "+ mountainbike.gear);
		System.out.println("Speed is "+mountainbike.speed);
//		System.out.println("Seat height is "+mountainbike.seatheight);
		mountainbike.applyBreak(1);
		mountainbike.speedUp(5);
		System.out.println("speed after modifying is" +mountainbike.speed);
		
		
		

	}

}
