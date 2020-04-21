package com.qa.ims.controller;

import com.qa.ims.persistence.domain.Order;
import java.util.List;

import javax.naming.directory.InvalidAttributeIdentifierException;

import org.apache.log4j.Logger;

import java.math.BigDecimal;
import com.qa.ims.services.CrudServices;
import com.qa.ims.services.OrderServices;
import com.qa.ims.utils.Utils;


// Takes details of an order for CRUD functional
public class OrderController implements CrudController<Order> {
	public static final Logger LOGGER = Logger.getLogger(OrderController.class);
	
	private CrudServices<Order> orderService;
	
	public OrderController(CrudServices<Order> orderService) {
		this.orderService = orderService;
	}
	
	String getInput() {
		return Utils.getInput();
	}
	
	//Read all the orders in the logger
	@Override
	public List<Order> readAll() {
		List<Order> orders = orderService.readAll();
		for (Order order: orders) {
			LOGGER.info(order.toString());
		}
		return orders;
	}
	
//	public Order read() {
//		LOGGER.info("Please enter the order's ID: ");
//		Long orderid = Long.getLong(getInput());
//		Order singleOrder = orderService.read(orderid);
//		return singleOrder;
//	}

	//Creates an order from the user input
	@Override
	public Order create() {
		Long customerid;
		BigDecimal totalprice = BigDecimal.valueOf(0);
		
		do {
			try {
				LOGGER.info("Please place your order");
				Long orderid = Long.getLong(getInput());
			} catch (NullPointerException nfe) {
				LOGGER.info("please enter an integer number to procceed");
			}
		} while (customerid == null || customerid < 0);
		
		boolean format;	
		boolean except;
		do {
			format = false;
			try {
				if ()
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			
			format = true;
		} while (!format);
		
		
		Order order = orderService.create(new Order(customerid, totalprice));
		LOGGER.info("Order created");
		return order;
			
		}
		
		
	

	@Override
	public Order update() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete() {
		LOGGER.info("Please enter your order id to delete the order");
		Long orderid = Long.valueOf(getInput());
		orderService.delete(orderid);
		LOGGER.info("Order with id: " + orderid + " deleted");
	}

}
