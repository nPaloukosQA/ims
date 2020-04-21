package com.qa.ims.controller;

import com.qa.ims.persistence.domain.Order;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.qa.ims.services.CrudServices;
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
		LOGGER.info("Please enter the order's id:");
		Long orderid = Long.getLong(getInput());
		LOGGER.info("Please enter how many items you want to order");
		Long numberOfItems = Long.getLong(getInput());
		List<Long> itemid = new ArrayList<>();
		for (int i = 0; i <= numberOfItems; i++) {
			LOGGER.info("Enter the id of the item " + i + ": ");
			itemid.add(Long.getLong(getInput()));
		}
		Order order = orderService.create(new Order(orderid, itemid));
		LOGGER.info("Order placed");		
		return order;
		}
		
		
	

	@Override
	public Order update() {
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
