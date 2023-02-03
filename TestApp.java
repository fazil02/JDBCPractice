package com.jdbcproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestApp {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//1.register and loading the driver
		//Class.forName("com.mysql.cj.jdbc.Driver");
		
		System.out.println("driver is loaded..!!");
		
		//2.get connection
		String url = "jdbc:mysql://localhost:3306/telusko?autoReconnect=true&useSSL=false";
		String user = "root";
		String pass = "admin";
		Connection connection = DriverManager.getConnection(url,user,pass);
		
		System.out.println("Connection with sql is established..!!");
		
		//3.create statement object and execute the query
		String selectquery = "select * from telusko.alien";
		Statement statement=connection.createStatement();
		
		ResultSet resultset=statement.executeQuery(selectquery);
		
		System.out.println("created statement obj..!!");
		
		//4.process the result set
		while(resultset.next())
		{
			int id = resultset.getInt(1);
			String stre = resultset.getString(2);
			System.out.println(id + " " +stre);
		}
		
		//5.handle the sql exception
		
		//6.close the connection
		
		resultset.close();
		statement.close();
		connection.close();
		
		System.out.println("connection is closed..!!");

	}

}
