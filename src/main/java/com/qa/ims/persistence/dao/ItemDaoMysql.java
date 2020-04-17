package com.qa.ims.persistence.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import com.qa.ims.persistence.domain.Item;


public class ItemDaoMysql extends DaoConnect implements Dao<Item> {
	public static final Logger LOGGER = Logger.getLogger(ItemDaoMysql.class);
	
	

	Item itemFromResultSet(ResultSet resultSet) throws SQLException {
		Long itemid = resultSet.getLong("itemid");
		String itemName = resultSet.getString("itemName");
		BigDecimal itemPrice = BigDecimal.valueOf(Double.parseDouble(resultSet.getString("itemPrice")));
		return new Item(itemid, itemName, itemPrice);
	}
	
	
	//Reads all items in the database	
	@Override
	public List<Item> readAll() {
		try (
				Connection connection = databaseConnect();
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
	
	public Item readLatest() {
		try (Connection connection = databaseConnect();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM items ORDER BY itemid DESC LIMIT 1");) {
			resultSet.next();
			return itemFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}


	//Creates an item in the database
	@Override
	public Item create(Item item) {
		try (Connection connection = databaseConnect();
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("insert into items (itemName, itemPrice) VALUES ('" + item.getItemName()
					+ "','" + item.getItemPrice() + "')");
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	public Item readItem(Long itemid) {
		try (Connection connection = databaseConnect();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM items WHERE itemid =" + itemid);) {
			resultSet.next();
			return itemFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	
//Updates an item in the database
	@Override
	public Item update(Item item) {
		try (Connection connection = databaseConnect();
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("UPDATE items SET itemName ='" + item.getItemName() + "', itemPrice = '"
					+ item.getItemPrice() + "' WHERE itemid ='" + item.getItemid() + "';");
			return readItem(item.getItemid());
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}

		return null;
	}

	//deletes an item in the database
	@Override
	public void delete(long itemid) {
		try (Connection connection = databaseConnect();
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("delete from items where itemid = " + itemid);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
	
	}

}
