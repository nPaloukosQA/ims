package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoConnect {
	
	private static String jdbcConnectionUrl = "jdbc:mysql://34.65.200.246:3306/ims";
	private static String username;
	private static String password;
	
	
	public static String getJdbcConnectionUrl() {
		return jdbcConnectionUrl;
	}
	
	public static String getUsername() {
		return username;
	}
	public static void setUsername(String username1) {
	username = username1;
	}
	public  String getPassword() {
		return password;
	}
	public static void setPassword(String password1) {
	password = password1;
	}
	
	public Connection databaseConnect() throws SQLException {
		return (DriverManager.getConnection(jdbcConnectionUrl, username, password));
	}
	
	public void databaseClose(Connection connect) throws SQLException {
		connect.close();
	}

}