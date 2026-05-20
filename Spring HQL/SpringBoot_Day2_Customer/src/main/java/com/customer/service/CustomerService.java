package com.customer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.dao.CustomerDao;
import com.customer.entity.CustomerEntity;

@Service
public class CustomerService {
	
	@Autowired
	CustomerDao dd;
	
	public String insertData(CustomerEntity cs) {
		
		String sm = dd.insertData(cs);
		
		return sm;
	}
	
	public String deletData(int id) {
		
		String msg = dd.deletData(id);
		
		return msg;
	}
	
	public String updataData(CustomerEntity cs , int id) {
		
		String ms = dd.updateData(cs, id);
		
		return ms;
	}
	
	public CustomerEntity getData(int id) {
		
		CustomerEntity ms = dd.getDataById(id); 
		
		return ms;
	}
	
	// get all data
	
	public java.util.List<CustomerEntity> getAllData() {
		
		java.util.List<CustomerEntity> ms = dd.getAllData();
		
		return ms;
	}

	
	

}
