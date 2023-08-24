package codingnnja_extrapracticeexamples;

public class Cuboid 
{	
	int width;
	int height;
	int depth;
	
	public Cuboid(int width,int height,int depth)
	{
		this.width=width;
		this.height=height;
		this.depth=depth;
	}
	public Cuboid(int width, int height)
	{
		this.width=width;
		this.height=height;
		this.depth=10;
	}
	public Cuboid(int dimension)
	{
		this.width=dimension;
		this.height=dimension;
		this.depth=dimension;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	public Cuboid()
	{
		this.width=10;
		this.height=10;
		this.depth=10;
	}
	public int volume()
	{
		int volumeResult=width*height*depth;
		return volumeResult;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cuboid c1=new Cuboid(10,12,13);
		System.out.println(c1.volume());
		Cuboid c2=new Cuboid(15,10);
		System.out.println(c2.volume());
		Cuboid c3=new Cuboid(11);
		System.out.println(c3.volume());
		Cuboid c4=new Cuboid();
		System.out.println(c4.volume());
		

	}

}
