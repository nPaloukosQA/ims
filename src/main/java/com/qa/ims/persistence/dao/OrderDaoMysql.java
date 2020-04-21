package com.qa.ims.persistence.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

import org.apache.log4j.Logger;

import com.qa.ims.persistence.domain.Order;

public class OrderDaoMysql extends DaoConnect implements Dao<Order> {
	public static final Logger LOGGER = Logger.getLogger(OrderDaoMysql.class);
	
	
	Order orderFromResultSet(ResultSet resultSet) throws SQLException {
		Long orderid = (long) resultSet.getInt("orderid");
		Long customerid = (long) resultSet.getInt("customerid");
		List<Long> itemid = readItemid(orderid);
		BigDecimal totalprice = BigDecimal.valueOf(resultSet.getDouble("totalprice"));
		return new Order (orderid, customerid, totalprice, itemid);
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
	public Order create(Order order) {
		if (order.getTotalprice() == null) {
			order.setTotalprice(calculateTotalPrice(order.getItemid()));
		}
//		try (Connection connection =databaseConnect(); Statement statement = connection.createStatement();) {
//		//	statement.executeUpdate("INSERT INTO orders(customerid, totalPrice") VALUES ('");
//			statement.executeUpdate("INSERT INTO orders (customerid, totalPrice) VALUES ('" + ;
//		} catch (Exception e) {
//			// TODO: handle exception
//		}

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
	
	public List<Long> readItemid(Long orderid) {
		try (Connection connection = databaseConnect(); Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT itemid FROM items WHERE orderid = " + orderid.intValue());) {
			List<Long> itemid = new ArrayList<>();
			while (resultSet.next()) {
				itemid.add(resultSet.getLong(1));
			}
			return itemid;
		} catch (SQLException sqle) {
			LOGGER.debug(sqle.getStackTrace());
			LOGGER.error(sqle.getMessage());
		}
		return Collections.emptyList();
	}
	
	public BigDecimal calculateTotalPrice(List<Long> itemid) {
		BigDecimal total = new BigDecimal(0);
		for (Long orderid: itemid) {
			try (Connection connection = databaseConnect(); Statement statement = connection.createStatement();
					ResultSet resultSet = statement.executeQuery("select totalPrice FROM items WHERE itemid = " + itemid + "LIMIT 1");) {
				total = total.add(BigDecimal.valueOf(resultSet.getLong(1)));
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return total;
	}
	
	 
}
