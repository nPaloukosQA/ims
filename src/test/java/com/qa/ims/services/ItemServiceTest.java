package com.qa.ims.services;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.persistence.dao.Dao;
import com.qa.ims.persistence.domain.Item;

@RunWith(MockitoJUnitRunner.class)
public class ItemServiceTest {
	
	@Mock
	private Dao<Item> itemDao;
	
	@InjectMocks
	private ItemService itemService;
	
	@Test
	public void itemServiceCreate() {
		Item item = new Item("GreatBall", BigDecimal.valueOf(Double.valueOf(450)));
		itemService.create(item);
		Mockito.verify(itemDao, Mockito.times(1)).create(item);
	}
	
	@Test
	public void itemServiceRead() {
		itemService.readAll();
		Mockito.verify(itemDao, Mockito.times(1)).readAll();
	}
	
	@Test
	public void itemServiceUpdate() {
		Item item = new Item("UltraBall", BigDecimal.valueOf(Double.valueOf(750)));
		itemService.update(item);
		Mockito.verify(itemDao, Mockito.times(1)).update(item);
	}
	
	@Test
	public void itemServiceDelete() {
		itemService.delete(1L);
		Mockito.verify(itemDao, Mockito.times(1)).delete(1L);
	}
}
