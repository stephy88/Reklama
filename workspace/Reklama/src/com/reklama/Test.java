package com.reklama;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.reklama.connection.DatabaseUtil;

public class Test {
public static void main(String[] args) throws ClassNotFoundException, SQLException 
{
	String name = "Sara";
	String sql = "INSERT INTO bzvz"
			+ "(name) VALUES"
			+ "(?)";
	PreparedStatement preparedStatement = DatabaseUtil.getStatement(sql);
	System.out.println("Begin");
	try {
		//preparedStatement.setInt(1, 3);
		preparedStatement.setString(1, name);
		preparedStatement.executeUpdate();
		
		
		System.out.println("Saved");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("Error");
		//writer.print("<div class='alert alert-success'> <strong>Success!</strong> Indicates a successful or positive action.</div>");
	}
	/*DatabaseUtil util = new DatabaseUtil();
	PreparedStatement statement = util.getStatement("SELECT * FROM bzvz");
	
	ResultSet result = statement.executeQuery();
	
	while(result.next())
	{
		int id  = result.getInt("id");
	    System.out.println(id);
	}*/
	
	/*PreparedStatement statement = DatabaseUtil.getStatement("SELECT * FROM bzvz");
	  ResultSet result = statement.executeQuery();
	  
	  while(result.next())
	  {
		  int id = result.getInt("id");
		  String name = result.getString("name");
		  
		  System.out.println(name);
	  }*/
	/*Class.forName("org.postgresql.Driver");
	Connection connection = null;
	connection = DriverManager.getConnection(
	   "jdbc:postgresql://localhost:5432/stefan","postgres", "Stef.dev251188");    	      
      //STEP 4: Execute a query
      System.out.println("Creating statement...");
      Statement statement = connection.createStatement();

      ResultSet rs = statement.executeQuery("SELECT * FROM bzvz");
      while(rs.next()){
      //Retrieve by column name
      int id  = rs.getInt("id");
      System.out.println(id);
       }*/
	
	/*try
    {
	int id = 2;
	String name = "Kengura";
	
	String sql = "update bzvz set name = ? where id = ?";
      // create a java mysql database connection
     PreparedStatement preparedStmt = DatabaseUtil.getStatement(sql);
      
      // create the java mysql update preparedstatement
     
      preparedStmt.setString(1, name);
      preparedStmt.setInt (2, id);
      

      // execute the java preparedstatement
      preparedStmt.executeUpdate();
      
    }
    catch (Exception e)
    {
      System.err.println("Got an exception! ");
      System.err.println(e.getMessage());
    }*/
}
}
