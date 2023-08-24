package serializationdeserialisation;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationDemo 
{

	public static void main(String[] args) throws IOException, ClassNotFoundException 
	{
		Student student=new Student(12, "vishal jain", "jain Street, chamarajanagar");
		student.setX(10);
		System.out.println(student.getX());
		String filname="E:\\javaserializable\\ser.txt";
		
		FileOutputStream fileOut=null;
		ObjectOutputStream objOut=null;
		
		
		//serialization
		fileOut=new FileOutputStream(filname);
		objOut=new ObjectOutputStream(fileOut);
		objOut.writeObject(student);
		System.out.println("object is now serialized");
		System.out.println(student);
		fileOut.close();
		objOut.close();
		
		FileInputStream fileIn=null;
		ObjectInputStream objIn=null;
		
//		desirialization
		fileIn=new FileInputStream(filname);
		objIn=new ObjectInputStream(fileIn);
		Student student1=(Student)objIn.readObject();
		
		System.out.println("object is now desirialized");
		System.out.println(student1);
		System.out.println(student1.getX());
		fileIn.close();
		objIn.close();
	}

}
