package com.qa.ims.controller;

import java.util.List;
import org.apache.log4j.Logger;

import java.math.BigDecimal;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.services.CrudServices;
import com.qa.ims.utils.Utils;


// Takes in item details for CRUD functional
public class ItemController implements CrudController<Item> {
	public static final Logger LOGGER = Logger.getLogger(ItemController.class);
	
	private CrudServices<Item> itemService; 
	
	public ItemController(CrudServices<Item> itemService) {
		this.itemService = itemService;
	}
	
	String getInput() {
		return Utils.getInput();
	}
	
	//Read all Items in the logger
	@Override
	public List<Item> readAll() {
		List<Item> items = itemService.readAll();
		for (Item item: items) {
			LOGGER.info(item.toString());
		}
		return items;
	}
	
	//Create an item from user input
	@Override
	public Item create() {
		LOGGER.info("Add the name of the item");
		String itemName = getInput();
		LOGGER.info("Please enter the price of the item");
		BigDecimal itemPrice = BigDecimal.valueOf(Double.parseDouble(getInput()));
		Item item = itemService.create(new Item(itemName, itemPrice));
		LOGGER.info("Item created");
		return item;
	}

	//Updates an existing item by taking a user input
	@Override
	public Item update() {
		LOGGER.info("Enter the ID of the item you want to update");
		Long itemid = Long.valueOf(getInput());
		LOGGER.info("Please enter the item's name");
		String itemName = getInput();
		LOGGER.info("Please enter the item's price");
		BigDecimal itemPrice = BigDecimal.valueOf(Double.parseDouble(getInput()));
		Item item = itemService.update(new Item(itemid, itemName, itemPrice));
		LOGGER.info("Item updated");
		return item;		
	}
	
	//Delete an existing item from the user by the id
	@Override
	public void delete() {
		LOGGER.info("Please enter the id of the item you want to delete");
		Long itemid = Long.valueOf(getInput());
		itemService.delete(itemid);
		LOGGER.info("Item with id: " + itemid + " deleted");
		
	}
	
}
