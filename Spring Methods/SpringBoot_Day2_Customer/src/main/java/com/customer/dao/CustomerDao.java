package com.customer.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.customer.entity.CustomerEntity;

@Repository
public class CustomerDao {

	@Autowired
	SessionFactory factory;

	public String insertData(CustomerEntity c) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		session.persist(c);

		transaction.commit();
		session.close();

		return "Data Indserted ...";
	}
	
	public String deletData(int id) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		CustomerEntity ee = session.find(CustomerEntity.class, id);

		session.remove(ee);
		transaction.commit();
		session.close();

		return "Data Indserted ...";
	}
	
	public String updateData(CustomerEntity c , int id) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		CustomerEntity cs = session.find(CustomerEntity.class, id);
		cs.setCustomerId(c.getCustomerId());
		cs.setCustomerName(c.getCustomerName());
		cs.setCustomerAge(c.getCustomerAge());
		cs.setCustomerBalance(c.getCustomerBalance());
		cs.setCustomerCountry(c.getCustomerCountry());
		cs.setCustomerCity(c.getCustomerCity());
		cs.setCustomerGender(c.getCustomerGender());
		cs.setCustomerState(c.getCustomerState());
		cs.setCustomerMobile(c.getCustomerMobile());
		cs.setCustomerEmail(c.getCustomerEmail());
		
		session.merge(cs);

		transaction.commit();
		session.close();

		return "Data Indserted ...";
	}
	
	public CustomerEntity getsingleData(int id) {
		Session session = factory.openSession();
		

		CustomerEntity cs = session.find(CustomerEntity.class, id);

		
		session.close();

		return cs;
	}
	
	public List<CustomerEntity> getallData() {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		Query<CustomerEntity> q = session.createQuery("from CustomerEntity", CustomerEntity.class);
		
		List<CustomerEntity> list = q.list();

		transaction.commit();
		session.close();

		return list;
	}

}
