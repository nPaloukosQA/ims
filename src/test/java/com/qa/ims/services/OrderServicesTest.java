package com.qa.ims.services;

import java.util.ArrayList;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
import java.util.List;
=======
>>>>>>> 56de168528f315e707cd97f341c445c936b1c579
=======
import java.util.List;
>>>>>>> parent of c659069... commiting changes for uploading on jenkins
=======
import java.util.List;
>>>>>>> parent of c659069... commiting changes for uploading on jenkins

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
<<<<<<< HEAD
<<<<<<< HEAD
	private Dao<Order> orderDao;
=======
	private Dao<Order> orderDaoServices;
>>>>>>> 56de168528f315e707cd97f341c445c936b1c579
=======
	private Dao<Order> orderDao;
>>>>>>> parent of c659069... commiting changes for uploading on jenkins
=======
	private Dao<Order> orderDao;
>>>>>>> parent of c659069... commiting changes for uploading on jenkins
	
	@InjectMocks
	private OrderServices orderServices;
	
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> parent of c659069... commiting changes for uploading on jenkins
=======
>>>>>>> parent of c659069... commiting changes for uploading on jenkins
//	@Test
//	public void orderServiceCreate() {
//		List<Long> itemid = new ArrayList<Long>(1);
//		Order order = new Order(Long.valueOf(1), itemid);
//		orderServices.create(order);
//		Mockito.verify(orderDao, Mockito.times(1)).readAll();
//	}
<<<<<<< HEAD
<<<<<<< HEAD
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
=======
>>>>>>> parent of c659069... commiting changes for uploading on jenkins
=======
>>>>>>> parent of c659069... commiting changes for uploading on jenkins

}
