package com.one.hibertest.pojo;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="address")
public class Address {
 
	@EmbeddedId
	AdrCompKey addressId;
	
	@Column(name="street")
	String street;
	
	@Column(name="city")
	String city;
	
	@Column(name="state")
	String state;
	
	
	
	public Address() {
		super();
	}

	public Address(AdrCompKey addressId, String street, String city, String state, String pincode) {
		super();
		this.addressId = addressId;
		this.street = street;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}

	@Column(name="pincode")
	String pincode;



	public AdrCompKey getAddressId() {
		return addressId;
	}

	public void setAddressId(AdrCompKey addressId) {
		this.addressId = addressId;
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
		return "Address [addressId=" + addressId + ", street=" + street + ", city=" + city + ", state=" + state
				+ ", pincode=" + pincode + "]";
	}
	
}
