package inputooutputstream;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharacterStreamDemo
{

	public static void main(String[] args) throws IOException
	{
		FileReader inputReader=null;
		FileWriter outputWriter=null;
		try 
		{
			File file=new File("E:\\javacharstreamdemo\\sourcee.txt");
			System.out.println(file.exists());
			inputReader=new FileReader("E:\\javacharstreamdemo\\sourcee.txt");
			outputWriter=new FileWriter("E:\\javacharstreamdemo\\dest.txt");
			int content;
			while((content=inputReader.read())!=-1)
			{
//				outputWriter.write((char)content);
				outputWriter.append((char)content);
			}
		} 
		finally 
		{
			if(inputReader!=null)
			{
				inputReader.close();
			}
			if(outputWriter!=null)
			{
				outputWriter.close();
			}
		}
	}
}
