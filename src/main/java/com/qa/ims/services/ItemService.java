package com.qa.ims.services;

import java.util.List;


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
	public Item update(Item item) {
		return itemDao.update(item);
	}

	@Override
	public void delete(Long itemid) {
		itemDao.delete(itemid);		
	}

}
