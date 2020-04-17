package com.qa.ims.persistence.domain;

public class Orderline {
	private Long orderid;
	private Long itemid;
	private Long quantity;
	
	public Orderline(Long orderid, Long itemid, Long quantity) {
		this.orderid = orderid;
		this.itemid = itemid;
		this.quantity = quantity;		
	}
	
	
	public Long getOrderid() {
		return orderid;
	}
	public void setOrderid(Long orderid) {
		this.orderid = orderid;
	}
	public Long getItemid() {
		return itemid;
	}
	public void setItemid(Long itemid) {
		this.itemid = itemid;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return "order id" + orderid + "item id" + itemid + "quantity" + quantity;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderid == null) ? 0 : orderid.hashCode());
		result = prime * result + ((itemid == null) ? 0 : itemid.hashCode());
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
		return result;		
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Orderline other = (Orderline) obj;
		if (orderid == null) {
			if (other.orderid != null)
				return false;
		} else if (!orderid.equals(other.orderid)) 
			return false;
		if (itemid == null) {
			if (other.itemid != null)
				return false;
		} else if (!itemid.equals(other.itemid)) 
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity)) 
			return false;
		return true;
	
	}	

}
