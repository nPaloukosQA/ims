package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class OrderTest {
	
	private Order order;
	private Order other;
	
	@Before
	public void setUp() {
		List<Long> itemid = new ArrayList<Long>();
		order = new Order(1L, Long.valueOf(1), itemid);
		other = new Order(1L, Long.valueOf(1), itemid);
	}
	
	@Test
	public void settersTest() {
		assertNotNull(order.getOrderid());
		assertNotNull(order.getCustomerid());
		assertNotNull(order.getItemid());
		
		order.setOrderid(null);
		assertNull(order.getOrderid());
		order.setCustomerid(null);
		assertNull(order.getCustomerid());
		order.setItemid(null);
		assertNull(order.getItemid());
	}

	@Test
	public void equalsWithNull() {
		assertFalse(order.equals(null));
	}
	
	@Test
	public void equalsWithDifferentObject() {
		assertFalse(order.equals(new Object()));
	}
	
	@Test
	public void createOrderWithID() {
		assertEquals(1L, order.getOrderid(), 0);
		assertEquals(Long.valueOf(1), order.getCustomerid());
		List<Long> itemid = new ArrayList<Long>();
		assertEquals(itemid,  order.getItemid());
	}
	
	@Test
	public void checkEqualtiy() {
		assertTrue(order.equals(order));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjects() {
		assertTrue(order.equals(other));
	}
	
	@Test
	public void orderidNullButOtherNameNotNull() {
		order.setOrderid(null);
		assertFalse(order.equals(other));
	}
	
	@Test
	public void orderIDsNotEqual() {
		other.setOrderid(Long.valueOf(10));
		assertFalse(order.equals(other));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjectsNullName() {
		order.setOrderid(null);
		other.setOrderid(null);
		assertTrue(order.equals(other));
	}
	
//	@Test
//	public void nullitemID() {
//		order.setItemid(null);
//		assertFalse(order.equals(other));
//	}
//	
//	@Test
//	public void nullitemIdOnBoth() {
//		order.setItemid(null);
//		other.setItemid(null);
//		assertTrue(order.equals(other));
//	}
	
	@Test
	public void otherIDisDifferent() {
		other.setOrderid(2L);
		assertFalse(order.equals(other));
	}
	
//	@Test
//	public void nullTotalPrice() {
//		order.setTotalprice(null);
//		assertFalse(order.equals(other));
//	}
	
	@Test
	public void nullTotalPriceOnBoth () {
		order.setTotalprice(null);
		other.setTotalprice(null);
		assertTrue(order.equals(other));
	}
	
	@Test
	public void otherPriceDifferent() {
		other.setTotalprice(BigDecimal.valueOf(Double.valueOf(200)));
		assertFalse(order.equals(other));
	}
	
	@Test
	public void constructorWithoutID() {
		List<Long> itemid = new ArrayList<Long>();
		Order order = new Order(Long.valueOf(1), itemid);
		assertNull(order.getOrderid());
		assertNotNull(order.getItemid());
	}
	
	@Test
	public void hashcodeTest() {
		assertEquals(order.hashCode(), other.hashCode());
	}
	
	@Test
	public void hashcodeTestWithNull() {
		Order order = new Order(null, null);
		Order other = new Order(null, null);
		assertEquals(order.hashCode(), other.hashCode());
	}
	
//	@Test
//	public void toStringTest() {
//		String toString = "itemid:1 item name:Pokeball item price:200";
//		assertEquals(toString, item.toString());
//	}
	
}
