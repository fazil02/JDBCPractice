package com.jdbcproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateApp {

	public static void main(String[] args) throws SQLException {
		
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
				String updatequery = "update telusko.alien set aname = 'admin' where aid = '120' ";
				Statement statement=connection.createStatement();
				
				int resultset=statement.executeUpdate(updatequery);
				
				System.out.println("query inserted "+ resultset);
				
				System.out.println("created statement obj..!!");
				
				

				//resultset.close();
				statement.close();
				connection.close();
				
				System.out.println("connection is closed..!!");


	}

}
