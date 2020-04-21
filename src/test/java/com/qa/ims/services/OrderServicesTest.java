package com.qa.ims.services;

import java.util.ArrayList;
import java.util.List;

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
	private Dao<Order> orderDao;
	
	@InjectMocks
	private OrderServices orderServices;
	
//	@Test
//	public void orderServiceCreate() {
//		List<Long> itemid = new ArrayList<Long>(1);
//		Order order = new Order(Long.valueOf(1), itemid);
//		orderServices.create(order);
//		Mockito.verify(orderDao, Mockito.times(1)).readAll();
//	}

}
