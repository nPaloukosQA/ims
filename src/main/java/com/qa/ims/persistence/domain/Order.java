package com.qa.ims.persistence.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Order {
	
	private Long orderid;
	private Long customerid;
	private BigDecimal totalprice;	
	private List<Long> itemid = new ArrayList<>();
	
	public Order (Long customerid, List<Long> itemid) {
		super();
		this.customerid = customerid;
		this.itemid = itemid;
		
	}
	
	public Order (Long orderid, Long customerid, List<Long> itemid) {
		super();
		this.orderid = orderid;
		this.customerid = customerid;
		this.itemid = itemid;
		}
	
	public Order(Long customerid, BigDecimal totalprice, List<Long> itemid) {
		super();
		this.customerid = customerid;
		this.totalprice = totalprice;
		this.itemid = itemid;
	}
	
	public Order(Long orderid, Long customerid, BigDecimal totalprice, List<Long> itemid) {
		super();
		this.orderid = orderid;
		this.customerid = customerid;
		this.totalprice = totalprice;
		this.itemid = itemid;
		
	}
	


	public Long getOrderid() {
		return orderid;
	}

	public void setOrderid(Long orderid) {
		this.orderid = orderid;
	}

	public Long getCustomerid() {
		return customerid;
	}

	public void setCustomerid(Long customerid) {
		this.customerid = customerid;
	}

	public BigDecimal getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(BigDecimal totalprice) {
		this.totalprice = totalprice;
	}
	
	public List<Long> getItemid() {
		return itemid;
	}

	public void setItemid(List<Long> itemid) {
		this.itemid = itemid;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderid == null ) ? 0 : orderid.hashCode());
		result = prime * result + ((customerid == null ) ? 0 : customerid.hashCode());
		result = prime * result + ((totalprice == null ) ? 0 : totalprice.hashCode());
		result = prime * result + ((itemid == null ) ? 0 : itemid.hashCode());
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
		Order other = (Order) obj;
		if (orderid == null) {
			if (other.orderid != null)
				return false;
		} else if (!orderid.equals(other.orderid)) 
			return false;
		if (customerid == null) {
			if (other.customerid !=null)
				return false;
		} else if (!customerid.equals(other.customerid)) 
			return false;
		if (totalprice == null) {
			if (other.totalprice !=null)
				return false;
		} else if (!totalprice.equals(other.totalprice)) 
			return false;
		if (itemid.isEmpty()) {
			if(!other.itemid.isEmpty()) 
				return false;
		} else {
			try {
				for (int i =0; i < itemid.size(); i++) {
					if (itemid.get(i) != other.itemid.get(i)) {
						return false;
					}
				}
			} catch (NullPointerException npe) {
				return false;
			}
		}
		return true;
	}	
}
