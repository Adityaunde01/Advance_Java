package com.one.hibertest.pojo;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AdrCompKey {
	
	@Column(name="uid")
	Integer userId;
	@Column(name="address_id")
	Integer address_id;
	
	
	public AdrCompKey() {
		super();
	}

	public AdrCompKey(Integer userId, Integer address_id) {
		super();
		this.userId = userId;
		this.address_id = address_id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getAddress_id() {
		return address_id;
	}

	public void setAddress_id(Integer address_id) {
		this.address_id = address_id;
	}

	@Override
	public String toString() {
		return "AdrCompKey [userId=" + userId + ", address_id=" + address_id + "]";
	}
	
	
}
