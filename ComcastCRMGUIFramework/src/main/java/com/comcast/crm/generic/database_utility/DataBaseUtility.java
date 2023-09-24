package com.comcast.crm.generic.database_utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import com.mysql.jdbc.Driver;

public class DataBaseUtility {
	Connection connection;
	public void getDbConnection() throws SQLException {
		try {
			Driver driver=new Driver();
			
			DriverManager.registerDriver(driver);
			
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
		} catch (Exception e) {
			
		}
		
		
	}
	
		public void getDbConnection(String url, String userName,String password) throws SQLException {
			try {
				Driver driver=new Driver();
				
				DriverManager.registerDriver(driver);
				
				connection=DriverManager.getConnection(url,userName,password);
			} catch (Exception e) {
				
			}
			
			
		}
	public void closeDbConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ResultSet executeSelectQuery(String query) {
		ResultSet result=null;
		try {
			Statement statement=connection.createStatement();
			 result=statement.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	
	public int executeNonSelectQuery(String query) {
		int result=0;
		try {
			Statement statement=connection.createStatement();
		result=statement.executeUpdate(query);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
}
