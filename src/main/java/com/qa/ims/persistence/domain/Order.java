package com.qa.ims.persistence.domain;

import java.util.Objects;

public class Order {

	private Long id;
	private Long customerid;
	
	public Order(Long id, Long customerid) {
		this.setId(id);
		this.setCustomerid(customerid);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCustomerid() {
		return customerid;
	}

	public void setCustomerid(Long customerid) {
		this.customerid = customerid;
	}
	
	@Override
	public String toString() {
		return "id:" + id + " customer id:" + customerid;
	}

	@Override
	public int hashCode() {
		return Objects.hash(customerid, id);
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
		return Objects.equals(customerid, other.customerid) && Objects.equals(id, other.id);
	}
	
	
}
