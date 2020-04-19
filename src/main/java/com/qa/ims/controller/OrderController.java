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
	


	//Creates an order from the user input
	@Override
	public Order create() {
		List<Long> itemid = new ArrayList<>();
		LOGGER.info("Please enter a customer id:");
		Long customerid = Long.valueOf(getInput());
		String addItems = "Yes";
		while (addItems.equalsIgnoreCase("Yes")) {
			LOGGER.info("Please enter an itemid to add in your order");
			LOGGER.warn("The itemid must exist in the items table");
			Long someitem = Long.valueOf(getInput());
			itemid.add(someitem);
			LOGGER.info("Would you like to add another item to this order? (Enter 'Yes' to continue adding items)");
			addItems = getInput();
		}
		Order order = orderService.create(new Order(customerid, itemid));
		LOGGER.info("Order placed");		
		return order;
		}
		
		
	

	@Override
	public Order update() {
		ArrayList<Long> itemid = new ArrayList<Long>();
		LOGGER.info("Please enter the orderid that you want to update: ");
		Long orderid = Long.valueOf(getInput());
		String changeItems = "Yes";
		while (changeItems.equalsIgnoreCase("Yes")) {
			LOGGER.info("Please enter an itemid to add to the order:");
			LOGGER.warn("The item must exist in the item table.");
			Long someitem = Long.valueOf(getInput());
			itemid.add(someitem);
			LOGGER.info("Would you like to add another item to this order? Enter 'Yes' to add more");
			changeItems = getInput();
		}
		Order order = orderService.update(new Order(orderid, itemid));
		LOGGER.info("Order updated.");
		return order;
	}

	@Override
	public void delete() {
		LOGGER.info("Please enter your order id to delete the order");
		Long orderid = Long.valueOf(getInput());
		orderService.delete(orderid);
		LOGGER.info("Order with id: " + orderid + " deleted");
	}

}
