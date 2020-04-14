package com.qa.ims.services;

import java.util.List;

import javax.sound.sampled.LineListener;

import com.qa.ims.persistence.dao.Dao;
import com.qa.ims.persistence.domain.Item;

public class ItemService implements CrudServices<Item> {
	
	private Dao<Item> itemDao;
	
	public ItemService(Dao<Item> itemDao) {
		this.itemDao = itemDao;
	}
	
	public List<Item> readAll() {
		return itemDao.readAll();
	}
	
	public Item create(Item item) {
		return itemDao.create(item);
	}

	@Override
	public Item update(Item t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

}
