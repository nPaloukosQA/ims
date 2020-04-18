package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class ItemTest {
	
	private Item item;
	private Item other;
	
	@Before
	public void setUp() {
		item = new Item(1L, "Pokeball", BigDecimal.valueOf(200));
		other = new Item(1L, "Pokeball", BigDecimal.valueOf(200));
	}
	
	@Test
	public void settersTest() {
		assertNotNull(item.getItemid());
		assertNotNull(item.getItemName());
		assertNotNull(item.getItemPrice());
		
		item.setItemid(null);
		assertNull(item.getItemid());
		item.setItemNameString(null);
		assertNull(item.getItemName());
		item.setItemPrice(null);
		assertNull(item.getItemPrice());
	}
	
	@Test
	public void equalsWithNull() {
		assertFalse(item.equals(null));
	}
	
	@Test
	public void equalsWithDifferentObject() {
		assertFalse(item.equals(new Object()));
	}
	
	@Test
	public void createItemWithID() {
		assertEquals(1L, item.getItemid(), 0);
		assertEquals("Pokeball", item.getItemName());
		assertEquals(BigDecimal.valueOf(200), item.getItemPrice());
	}
	
	@Test
	public void checkEqualtiy() {
		assertTrue(item.equals(item));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjects() {
		assertTrue(item.equals(other));
	}
	
	@Test
	public void itemNameNullButOtherNameNotNull() {
		item.setItemNameString(null);
		assertFalse(item.equals(other));
	}
	
	@Test
	public void itemNamesNotEqual() {
		other.setItemNameString("gsBall");
		assertFalse(item.equals(other));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjectsNullName() {
		item.setItemNameString(null);
		other.setItemNameString(null);
		assertTrue(item.equals(other));
	}
	
	@Test
	public void nullID() {
		item.setItemid(null);
		assertFalse(item.equals(other));
	}
	
	@Test
	public void nullIdOnBoth() {
		item.setItemid(null);
		other.setItemid(null);
		assertTrue(item.equals(other));
	}
	
	@Test
	public void otherIDisDifferent() {
		other.setItemid(2L);
		assertFalse(item.equals(other));
	}
	
	@Test
	public void nullItemPrice() {
		item.setItemPrice(null);
		assertFalse(item.equals(other));
	}
	
	@Test
	public void nullItemPriceOnBoth () {
		item.setItemPrice(null);
		other.setItemPrice(null);
		assertTrue(item.equals(other));
	}
	
	@Test
	public void otherPriceDifferent() {
		other.setItemPrice(BigDecimal.valueOf(Double.valueOf(200)));
		assertFalse(item.equals(other));
	}
	
	@Test
	public void constructorWithoutID() {
		Item item = new Item("Pokeball", BigDecimal.valueOf(Double.valueOf(200)));
		assertNull(item.getItemid());
		assertNotNull(item.getItemName());
		assertNotNull(item.getItemPrice());
	}
	
	@Test
	public void hashcodeTest() {
		assertEquals(item.hashCode(), other.hashCode());
	}
	
	@Test
	public void hashcodeTestWithNull() {
		Item item = new Item(null, null);
		Item other = new Item(null, null);
		assertEquals(item.hashCode(), other.hashCode());
	}
	
	@Test
	public void toStringTest() {
		String toString = "itemid:1 item name:Pokeball item price:200";
		assertEquals(toString, item.toString());
	}

}
