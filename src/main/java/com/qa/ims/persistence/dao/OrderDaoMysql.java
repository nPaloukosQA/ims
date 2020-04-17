package com.qa.ims.persistence.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.qa.ims.persistence.domain.Order;

public class OrderDaoMysql extends DaoConnect implements Dao<Order> {
	public static final Logger LOGGER = Logger.getLogger(OrderDaoMysql.class);
	
	
	Order orderFromResultSet(ResultSet resultSet) throws SQLException {
		Long orderid = resultSet.getLong("orderid");
		Long customerid = Long.valueOf(Long.parseLong(resultSet.getString("customerid")));
		BigDecimal totalprice = BigDecimal.valueOf(Double.parseDouble(resultSet.getString("totalprice")));
		return new Order(orderid, customerid, totalprice);
	}
	
	//Reads all orders in the database
	@Override
	public List<Order> readAll() {
		try (Connection connection = databaseConnect();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("select * from orders");) {
					ArrayList<Order> orders = new ArrayList<>();
					Order temporder;
					while (resultSet.next()) {
						temporder = orderFromResultSet(resultSet);
			
						orders.add(temporder);
					}
					
					return orders;
				} catch (SQLException e) {
					LOGGER.debug(e.getStackTrace());
					LOGGER.error(e.getMessage());
				}
				return new ArrayList<>();
	}

	@Override
	public Order create(Order t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order update(Order t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(long orderid) {
		try (Connection connection = databaseConnect();
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("delete from orders where orderid = " + orderid);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		
	}
	 
}
