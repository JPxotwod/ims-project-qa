package com.qa.ims.persistence.domain;

import java.util.Objects;

public class OrderItem {
	
	private Long itemid;
	private Long orderid;
	private Long quantity;
	
	public OrderItem(Long orderid, Long itemid, Long quantity) {
		this.setItemid(itemid);
		this.setOrderid(orderid);
		this.setQuantity(quantity);
	}
		

	public Long getItemid() {
		return itemid;
	}

	public void setItemid(Long itemid) {
		this.itemid = itemid;
	}

	public Long getOrderid() {
		return orderid;
	}

	public void setOrderid(Long orderid) {
		this.orderid = orderid;
	}

	
	public Long getQuantity() {
		return quantity;
	}
	
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	
	
	@Override
	public String toString() {
		return String.format("orderid: %d itemid: %d quantity: %d", this.getOrderid(), this.getItemid(), this.getQuantity());
	}

	@Override
	public int hashCode() {
		return Objects.hash(itemid, orderid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItem other = (OrderItem) obj;
		return Objects.equals(itemid, other.itemid) && Objects.equals(orderid, other.orderid);
	}
}
	
