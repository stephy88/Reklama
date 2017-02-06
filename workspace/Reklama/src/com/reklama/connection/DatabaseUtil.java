package com.reklama.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DatabaseUtil {
	private static Connection connection = null;
    private static PreparedStatement statement = null;
    private static final String JDBC_DRIVER = "org.postgresql.Driver";  
	private static final String DB_URL = "jdbc:postgresql://localhost:5432/stefan";

	   //  Database credentials
	private static final String USER = "postgres";
	private static final String PASS = "Stef.dev251188";
	   
    
    /*public ResultSet getStatement(String sql) throws SQLException, ClassNotFoundException 
    {
    		Class.forName("org.postgresql.Driver");
        	Connection connection = null;
        	connection = DriverManager.getConnection(
        	   "jdbc:postgresql://localhost:5432/stefan","postgres", "Stef.dev251188");    	      
    	      System.out.println("Creating statement...");
    	      statement = connection.createStatement();

    	      ResultSet rs = statement.executeQuery(sql);
    	    
    	 return rs;
    } */
    
    
    public static PreparedStatement getStatement(String sql)
    {
		   try{
		      //STEP 2: Register JDBC driver
		      Class.forName(JDBC_DRIVER);

		      //STEP 3: Open a connection
		      System.out.println("Connecting to a selected database...");
		      connection = DriverManager.getConnection(DB_URL, USER, PASS);
		      System.out.println("Connected database successfully...");
		      
		      //STEP 4: Execute a query
		      System.out.println("Creating statement...");
		      statement = connection.prepareStatement(sql);
		      //STEP 5: Extract data from result set
		      //connection.close();
		     
		   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }
		   
		   System.out.println("Goodbye!");
		   return statement;
    }
    
    
    public static PreparedStatement getInsertStatement(String sql, int generateStyle)
    {
		   try{
		      //STEP 2: Register JDBC driver
		      Class.forName(JDBC_DRIVER);

		      //STEP 3: Open a connection
		      System.out.println("Connecting to a selected database...");
		      connection = DriverManager.getConnection(DB_URL, USER, PASS);
		      System.out.println("Connected database successfully...");
		      
		      //STEP 4: Execute a query
		      System.out.println("Creating statement...");
		      statement = connection.prepareStatement(sql, generateStyle);
		      //STEP 5: Extract data from result set
		      //connection.close();
		     
		   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }
		   
		   System.out.println("Goodbye!");
		   return statement;
    }

}
