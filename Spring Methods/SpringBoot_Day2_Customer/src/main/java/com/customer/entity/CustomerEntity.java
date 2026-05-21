package com.customer.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
public class CustomerEntity {
	
	@Id
	private int customerId;
	private String customerName;
	private String customerEmail;
	private long customerMobile;
	private String customerCity;
	private String customerState;
	private String customerCountry;
	private int customerAge;
	private String customerGender;
	private double customerBalance;
	
	
	
	public CustomerEntity() {
		super();
		// TODO Auto-generated constructor stub
	}



	public CustomerEntity(int customerId, String customerName, String customerEmail, long customerMobile,
			String customerCity, String customerState, String customerCountry, int customerAge, String customerGender,
			double customerBalance) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.customerMobile = customerMobile;
		this.customerCity = customerCity;
		this.customerState = customerState;
		this.customerCountry = customerCountry;
		this.customerAge = customerAge;
		this.customerGender = customerGender;
		this.customerBalance = customerBalance;
	}



	public int getCustomerId() {
		return customerId;
	}



	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}



	public String getCustomerName() {
		return customerName;
	}



	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}



	public String getCustomerEmail() {
		return customerEmail;
	}



	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}



	public long getCustomerMobile() {
		return customerMobile;
	}



	public void setCustomerMobile(long customerMobile) {
		this.customerMobile = customerMobile;
	}



	public String getCustomerCity() {
		return customerCity;
	}



	public void setCustomerCity(String customerCity) {
		this.customerCity = customerCity;
	}



	public String getCustomerState() {
		return customerState;
	}



	public void setCustomerState(String customerState) {
		this.customerState = customerState;
	}



	public String getCustomerCountry() {
		return customerCountry;
	}



	public void setCustomerCountry(String customerCountry) {
		this.customerCountry = customerCountry;
	}



	public int getCustomerAge() {
		return customerAge;
	}



	public void setCustomerAge(int customerAge) {
		this.customerAge = customerAge;
	}



	public String getCustomerGender() {
		return customerGender;
	}



	public void setCustomerGender(String customerGender) {
		this.customerGender = customerGender;
	}



	public double getCustomerBalance() {
		return customerBalance;
	}



	public void setCustomerBalance(double customerBalance) {
		this.customerBalance = customerBalance;
	}



	@Override
	public String toString() {
		return "CustomerEntity [customerId=" + customerId + ", customerName=" + customerName + ", customerEmail="
				+ customerEmail + ", customerMobile=" + customerMobile + ", customerCity=" + customerCity
				+ ", customerState=" + customerState + ", customerCountry=" + customerCountry + ", customerAge="
				+ customerAge + ", customerGender=" + customerGender + ", customerBalance=" + customerBalance + "]";
	}



	
	
	
	

}
