package com.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.customer.entity.CustomerEntity;
import com.customer.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	CustomerService ssd;

	@PostMapping("/register")
	public String insertData(@RequestBody CustomerEntity cs) {

		String msd = ssd.insertData(cs);

		return msd;
	}
	
	@DeleteMapping("/delet/{id}")
	public String deletData(@PathVariable int id) {
		
		String ms = ssd.deletData(id);
		
		return ms;
	}
	
	@PutMapping("/update/{id}")
	public String updateData(@RequestBody CustomerEntity cs ,@PathVariable int id) {
		String ms = ssd.updataData(cs, id);
		
		return ms;
	}
	
	@GetMapping("/getsingledata")
	public CustomerEntity getsingleData(@RequestParam int id) {
		
		CustomerEntity ms = ssd.getsingleData(id);
		
		return ms;
	}
	
	@GetMapping("/getalldata")
	public List<CustomerEntity> getAllData() {
		
		List<CustomerEntity> ms = ssd.getAllData();
		
		return ms;
	}


}
