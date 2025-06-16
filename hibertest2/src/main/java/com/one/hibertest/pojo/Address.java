package com.one.hibertest.pojo;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="address")
@NamedQueries({
    @NamedQuery(name = "getAllAddresses", query = "from Address"),
    @NamedQuery(name = "getUserSpecificAddress", query = "select obj from Address obj where obj.userId = :userID")
})
public class Address {
 
	@ManyToOne
	@JoinColumn(name="uid", insertable = false, updatable =  false)
	User userObject;
	
	
	@Id
	Integer address_id;	

	@Column(name="uid")
	Integer userId;
	
	@Column(name="street")
	String street;
	
	@Column(name="city")
	String city;
	
	@Column(name="state")
	String state;
	
	
	
	public Address() {
		super();
	}

	

	public Address(User userObject, Integer address_id, Integer userId, String street, String city, String state,
			String pincode) {
		super();
		this.userObject = userObject;
		this.address_id = address_id;
		this.userId = userId;
		this.street = street;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}



	@Column(name="pincode")
	String pincode;


	public User getUserObject() {
		return userObject;
	}



	public void setUserObject(User userObject) {
		this.userObject = userObject;
	}



	public Integer getAddress_id() {
		return address_id;
	}



	public void setAddress_id(Integer address_id) {
		this.address_id = address_id;
	}



	public Integer getUserId() {
		return userId;
	}



	public void setUserId(Integer userId) {
		this.userId = userId;
	}



	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}



	@Override
	public String toString() {
		return "Address [userObject=" + userObject + ", address_id=" + address_id + ", userId=" + userId + ", street="
				+ street + ", city=" + city + ", state=" + state + ", pincode=" + pincode + "]";
	}


	
}
