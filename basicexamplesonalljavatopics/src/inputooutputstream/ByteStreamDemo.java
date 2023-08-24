package inputooutputstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamDemo
{
	public static void main(String[] args) throws IOException
	{
		FileInputStream inputStream=null;
		FileOutputStream outputStream=null;
		try 
		{	
			File file=new File("E:\\javabytestreamdemo\\source.txt");
			System.out.println(file.exists());
			inputStream=new FileInputStream("E:\\javabytestreamdemo\\source.txt");
			outputStream=new FileOutputStream("E:\\javabytestreamdemo\\destination.txt");
			int content;
			while((content=inputStream.read())!=-1)
			{
				outputStream.write((byte)content);
			}
		}
		finally 
		{
			if(inputStream!=null)
			{
				inputStream.close();
			}
			if(outputStream!=null)
			{
				outputStream.close();
			}			
		}
	}
}
