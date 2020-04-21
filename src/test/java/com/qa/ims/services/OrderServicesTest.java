package com.qa.ims.services;

import java.util.ArrayList;
<<<<<<< HEAD
import java.util.List;
=======
>>>>>>> 56de168528f315e707cd97f341c445c936b1c579

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
<<<<<<< HEAD
	private Dao<Order> orderDao;
=======
	private Dao<Order> orderDaoServices;
>>>>>>> 56de168528f315e707cd97f341c445c936b1c579
	
	@InjectMocks
	private OrderServices orderServices;
	
<<<<<<< HEAD
//	@Test
//	public void orderServiceCreate() {
//		List<Long> itemid = new ArrayList<Long>(1);
//		Order order = new Order(Long.valueOf(1), itemid);
//		orderServices.create(order);
//		Mockito.verify(orderDao, Mockito.times(1)).readAll();
//	}
=======
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
	
>>>>>>> 56de168528f315e707cd97f341c445c936b1c579

}
