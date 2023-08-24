package jdbcdemo;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcDemo 
{

	public static void main(String[] args) throws SQLException
	{

//		Every database vendor will provide it's own connection url, below url is for postgresql 
		String database_url="jdbc:postgresql://localhost/test";
		
//		database_url with port number, not required, just in case
//		String database_url="jdbc:postgresql://localhost:5432/test";
		
//		Creating a Connection
		Connection conn=null;
		
		int rollno=02;
		String name="patiyal";
		int age = 25;
		String insertQuery="INSERT INTO student(rollno, name, age) VALUES("+rollno+",'"+name+"',"+age+")";
//		String insertQuery="INSERT INTO student VALUES("+rollno+",'"+name+"',"+age+")";
		String deleteQuery="DELETE FROM student where rollno = 02";
		
		try
		{
//		no matter which database vendor you use, you're always going to use DriverManager.getConnection()method to get the connection
//		to the database, username-postgres, password - gosi12345
			conn=DriverManager.getConnection(database_url,"postgres","gosi12345");
			
//		create a statement object, a statement may be anything- select,insert,delete,update
			Statement st=conn.createStatement();
			
//		executeUpdate() method is used to execute the statement for any insertion or deletion operation
//		executeUpdate() method returns the no of rows affected after the sql_Query run on the database server			
			int count=st.executeUpdate(insertQuery);
			if(count==1)
			{
				System.out.println("inserted successfully "+insertQuery);
			}
			else 
			{
				System.out.println("insertion failed");
			}
			int count1=st.executeUpdate(deleteQuery);
			if(count1>0)
			{
				System.out.println("Deleted specific no of rows in the table successfully - "+count1);
			}
			else
			{
				System.out.println("Specified row doesn't exist in the table");
			}
		}
		catch (Exception e) 
		{
			// TODO: handle exception
			System.err.println(e);
		}
		finally
		{
//			Never forget to close the database connection, because it's a costly connection and if u don't close it, your application
//			will face serious database bottlenecks
			conn.close();
		}
		

	}

}
