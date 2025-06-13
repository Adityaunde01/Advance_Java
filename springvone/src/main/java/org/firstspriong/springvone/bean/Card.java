package org.firstspriong.springvone.bean;

public class Card {
	Integer CardNo;
	String expiry;
	Float balance;
	
	
	public Card() {
		super();
	}


	public Card(Integer cardNo, String expiry, Float balance) {
		super();
		CardNo = cardNo;
		this.expiry = expiry;
		this.balance = balance;
	}

	
	
	

	public Integer getCardNo() {
		return CardNo;
	}


	public void setCardNo(Integer cardNo) {
		CardNo = cardNo;
	}


	public String getExpiry() {
		return expiry;
	}


	public void setExpiry(String expiry) {
		this.expiry = expiry;
	}


	public Float getBalance() {
		return balance;
	}


	public void setBalance(Float balance) {
		this.balance = balance;
	}


	@Override
	public String toString() {
		return "Card [CardNo=" + CardNo + ", expiry=" + expiry + ", balance=" + balance + "]";
	}
	
	
		
	
	
}
