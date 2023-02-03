package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//import com.mysql.jdbc.Statement;

public class Jdbc {

	public static void main(String[] args) throws SQLException 
	{
		Connection connection = null;
		Statement statement = null;
	    ResultSet	resultSet = null;
		try
		{
	     //register and loading the driver
	     //from jdbc4.x version it will automatically load driver for you
		 //  Class.forName("com.mysql.cj.jdbc.Driver");
		  System.out.println("driver is loaded successfully");
		  
		 //get connection
		 String url = "jdbc:MySql://localhost:3306/telusko?autoReconnect=true&useSSL=false";
		  
		 String user = "root";
		 String pass = "admin";
		
		 connection = DriverManager.getConnection(url,user,pass);
		 System.out.println("connected with sql");
		 
		 //create statement obj and exceute the query
		 String sql = "select * from telusko.alien";
		 statement= connection.createStatement();
		  resultSet=statement.executeQuery(sql);
		  
		  //process the resultset
		  while(resultSet.next())
		  {
			  int id = resultSet.getInt(1);
			  String s = resultSet.getString(2);
			  System.out.println(id + " " + s);
		  }
		}
//		catch(ClassNotFoundException ce)
//		{
//		  ce.printStackTrace();
//		}
		catch(SQLException s)
		{
		  s.printStackTrace();
		}
		
		catch(Exception e)
		{
		  e.printStackTrace();
		}
		//closing the connection
		resultSet.close();
		statement.close();
		connection.close();
		
		System.out.println("connection with sql is closed successfully..!!");
		
	}

}
