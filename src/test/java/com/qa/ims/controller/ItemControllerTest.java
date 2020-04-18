package com.qa.ims.controller;

import static org.junit.Assert.assertEquals;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.services.ItemService;

@RunWith(MockitoJUnitRunner.class)
public class ItemControllerTest {
	
	@Mock
	private ItemService itemService;
	
	/* @Spy is used to mock methods inside the components for
	 * testing and InjectMocks uses dependency injection to insert 
	 * the mock int the itemController
	*/

	@Spy
	@InjectMocks
	private ItemController itemController;
	
	@Test
	public void readAllTest() {
		ItemController itemController = new ItemController(itemService);
		List<Item> items = new ArrayList<Item>();
		items.add(new Item("iPhone", BigDecimal.valueOf(999.9)));
		items.add(new Item("Android", BigDecimal.valueOf(99.9)));
		Mockito.when(itemService.readAll()).thenReturn(items);
		assertEquals(items, itemController.readAll());
	}
	
	@Test
	public void createTest() {
		String itemName = "Samsung Galaxy S11";
		String itemPrice = "540.5";
		Mockito.doReturn(itemName, itemPrice).when(itemController).getInput();
		
		BigDecimal price = BigDecimal.valueOf(Double.parseDouble(itemPrice));
		
		Item item = new Item(itemName, price);
		Item savedItem = new Item(1L, itemName, price);
		Mockito.when(itemService.create(item)).thenReturn(savedItem);
		assertEquals(savedItem, itemController.create());
	}
	
	@Test
	public void updateTest() {
		String itemid = "1";
		String itemName = "Polystation34";
		String itemPrice = "34";
		Mockito.doReturn(itemid, itemName, itemPrice).when(itemController).getInput();
		Item item = new Item(1L ,"Polystation34", BigDecimal.valueOf(Double.valueOf(34)));
		Mockito.when(itemService.update(item)).thenReturn(item);
		assertEquals(item, itemController.update());
	}
	
	@Test
	public void deleteTest() {
		String itemid = "1";
		Mockito.doReturn(itemid).when(itemController).getInput();
		itemController.delete();
		Mockito.verify(itemService, Mockito.times(1)).delete(1L);
	}
}
