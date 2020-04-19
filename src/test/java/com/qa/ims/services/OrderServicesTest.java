package com.qa.ims.services;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.persistence.dao.Dao;
import com.qa.ims.persistence.domain.Order;

@RunWith(MockitoJUnitRunner.class)
public class OrderServicesTest {
	
	@Mock
	private Dao<Order> orderDaoServices;
	
	@InjectMocks
	private OrderServices orderServices;
	
	@Test
	public void orderServicesCreate() {
		ArrayList<Long> itemid = new ArrayList<Long>();
		Order order = new Order(null, itemid);
		orderServices.create(order);
		Mockito.verify(orderDaoServices, Mockito.times(1)).create(order);
	}
	
	@Test
	public void orderServiceRead() {
		orderServices.readAll();
		Mockito.verify(orderDaoServices, Mockito.times(1)).readAll();
	}
	
	@Test
	public void orderServicesUpdate() {
		ArrayList<Long> itemid = new ArrayList<Long>();
		Order order = new Order(null, itemid);
		orderServices.update(order);
		Mockito.verify(orderDaoServices, Mockito.times(1)).update(order);
	}
	
	@Test
	public void orderServicesDelete() {
		orderServices.delete(1L);
		Mockito.verify(orderDaoServices, Mockito.times(1)).delete(1L);
	}
	

}
