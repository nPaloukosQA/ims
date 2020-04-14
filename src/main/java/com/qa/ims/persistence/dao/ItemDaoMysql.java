package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.qa.ims.persistence.domain.Item;


public class ItemDaoMysql implements Dao<Item> {
	public static final Logger LOGGER = Logger.getLogger(ItemDaoMysql.class);
	
	private String jdbcConnectionUrl;
	private String username;
	private String password;

	public ItemDaoMysql(String username, String password) {
		this.jdbcConnectionUrl = "jdbc:mysql://34.65.137.247:3306/ims";
		this.username = username;
		this.password = password;
	}

	public ItemDaoMysql(String jdbcConnectionUrl, String username, String password) {
		this.jdbcConnectionUrl = jdbcConnectionUrl;
		this.username = username;
		this.password = password;
	}

	Item itemFromResultSet(ResultSet resultSet) throws SQLException {
		Long itemid = resultSet.getLong("itemid");
		String itemName = resultSet.getString("item_name");
		String itemPrice = resultSet.getString("itemPrice");
		return new Item(itemid, itemName, itemPrice);
	}
	
	
	//Reads all items in the database	
	@Override
	public List<Item> readAll() {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("select * from items");) {
					ArrayList<Item> items = new ArrayList<>();
					while (resultSet.next()) {
						items.add(itemFromResultSet(resultSet));
					}
					return items;
				} catch (SQLException e) {
					LOGGER.debug(e.getStackTrace());
					LOGGER.error(e.getMessage());
				}
				return new ArrayList<>();
	}



	@Override
	public Item create(Item t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item update(Item t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
