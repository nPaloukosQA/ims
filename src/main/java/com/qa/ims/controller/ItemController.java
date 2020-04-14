package com.qa.ims.controller;

import java.util.List;
import org.apache.log4j.Logger;
import java.security.PublicKey;

import javax.sound.sampled.LineListener;
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
			LOGGER.info(items.toString());
		}
		return items;
	}
	
	//Create an item from user input
	@Override
	public Item create() {
		LOGGER.info("Add the name of the item");
		String itemName = getInput();
		LOGGER.info("Please enter the price of the item");
		String itemPrice = getInput();
		Item item = itemService.create(new Item(itemName, itemPrice));
		LOGGER.info("Item created");
		return item;
	}

	@Override
	public Item update() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}
		
	//Update an existing item from the user
	
		
		
	

}











