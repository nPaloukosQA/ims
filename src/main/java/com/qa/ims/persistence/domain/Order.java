package com.qa.ims.persistence.domain;

import java.math.BigDecimal;

public class Order {
	
	private Long orderid;
	private Long customerid;
	private BigDecimal totalprice;	
	
	public Order(Long orderid, Long customerid, BigDecimal totalprice) {
		this.orderid = orderid;
		this.customerid = customerid;
		this.totalprice = totalprice;
	}
	
	public Order(Long customerid, BigDecimal totalprice) {
		this.customerid = customerid;
		this.totalprice = totalprice;
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
	
	
	public String toString() {
		return "order id" + orderid + "customer id" + customerid + "total price" + totalprice;
		
	}
	
	@Override
	public int hashCode() {
		final int prime = 50;
		int result = 1;
		result = prime * result + ((orderid == null ) ? 0 : orderid.hashCode());
		result = prime * result + ((customerid == null ) ? 0 : customerid.hashCode());
		result = prime * result + ((totalprice == null ) ? 0 : totalprice.hashCode());
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
		return true;
	}	
}
