package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoConnect {
	
	private String jdbcConnectionUrl = "jdbc:mysql://34.65.200.246:3306/ims";
	private String username;
	private String password;
	
	
	public String getJdbcConnectionUrl() {
		return jdbcConnectionUrl;
	}
	public void setJdbcConnectionUrl(String jdbcConnectionUrl) {
		this.jdbcConnectionUrl = jdbcConnectionUrl;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Connection databaseConnect() throws SQLException {
		return (DriverManager.getConnection(jdbcConnectionUrl, username, password));
	}
	
	public void databaseClose(Connection connect) throws SQLException {
		connect.close();
	}

}