package com.qa.ims.persistence.domain;

public class Item {
	
	private Long itemid;
	private String itemName;
	private String itemPrice;
	
	public Item(String itemName, String itemPrice ) {
		this.itemName = itemName;
		this.itemPrice = itemPrice;
	}
	
	public Item(Long itemid, String itemName, String itemPrice) {
		this.itemid = itemid;
		this.itemName = itemName;
		this.itemPrice = itemPrice;		
	}
	
	
	public Long getItemid() {
		return itemid;
	}
	public void setItemid(Long itemid) {
		this.itemid = itemid;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemNameString(String itemName) {
		this.itemName = itemName;
	}
	public String getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(String itemPrice) {
		this.itemPrice = itemPrice;
	}
	
	
	public String toString() {
		return "itemid:" + itemid + " item name:" + itemName + " item price:" + itemPrice;		
	}
	
	@Override
	public int hashCode() {
		final int prime = 50;
		int result =1;
		result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
		result = prime * result + ((itemid == null) ? 0 : itemid.hashCode());
		result = prime * result + ((itemPrice == null) ? 0 : itemPrice.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (itemName == null) {
			if (other.itemName != null) 
				return false;				
		} else if (!itemName.equals(other.itemName)) 
			return false;
		if (itemid == null) {
			if (other.itemid != null)
				return false;
		} else if (!itemid.equals(other.itemid)) 
			return false;
		if (itemPrice == null) 
			if (other.itemPrice != null) {
				return false;
		} else if (!itemPrice.equals(other.itemPrice)) 
			return false;
		return true;
	}			
}
