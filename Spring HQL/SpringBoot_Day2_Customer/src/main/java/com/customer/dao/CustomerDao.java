package com.customer.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.MutationQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.customer.entity.CustomerEntity;

@Repository
public class CustomerDao {

	@Autowired
	SessionFactory factory;

// insert data using hql query.
	public String insertData(CustomerEntity cs) {

		Session s = factory.openSession();
		Transaction tt = s.beginTransaction();

		
		MutationQuery q = s.createMutationQuery("insert into CustomerEntity(customerId,customerName,customerEmail,customerMobile,customerCity,customerState,customerCountry,customerAge,customerGender,customerBalance)values\r\n"
				+ "(:id,:name,:email,:mobile,\r\n"
				+ ":city,:state,:country,\r\n"
				+ ":age,:gender,:balance)\"\r\n"
				+ ");");
  // The values we set we have to pass them here 
		q.setParameter("id", cs.getCustomerId());
		q.setParameter("name", cs.getCustomerName());
		q.setParameter("email", cs.getCustomerEmail());
		q.setParameter("mobile", cs.getCustomerMobile());
		q.setParameter("city", cs.getCustomerCity());
		q.setParameter("state", cs.getCustomerState());
		q.setParameter("country", cs.getCustomerCountry());
		q.setParameter("age", cs.getCustomerAge());
		q.setParameter("gender", cs.getCustomerGender());
		q.setParameter("balance", cs.getCustomerBalance());
		
		q.executeUpdate();
		
		tt.commit();

		s.close();

		return "Data inserted...";

	}

	// delete data

	public String deletData(int id) {

		Session ss = factory.openSession();
		Transaction tt = ss.beginTransaction();

		MutationQuery mq = ss.createMutationQuery("delete from CustomerEntity where customerId=:id");
		
		mq.setParameter("id", id);
		// why doing set parameter id
		// because we have to pass the id which we want to delete and that id is coming from the controller and that id is coming from the user input.
		//here id in double quotes is the parameter name and id in set parameter is the value which we want to pass to that parameter.
// we are pasing the id to the parameter in the query.
		mq.executeUpdate();
		
		tt.commit();
		ss.close();

		return "Data is deleted....";

	}

	// update data

	public String updateData(CustomerEntity cs, int id) {

		Session sd = factory.openSession();
		Transaction tt = sd.beginTransaction();

	    MutationQuery q = sd.createMutationQuery("update CustomerEntity set customerName=:name,customerEmail=:email,customerMobile=:mobile,customerCity=:city,customerState=:state,customerCountry=:country,customerAge=:age,customerGender=: gender, customerBalance=:balance where customerId=:id");
		
		q.setParameter("name", cs.getCustomerName());
		q.setParameter("email", cs.getCustomerEmail());
		q.setParameter("mobile", cs.getCustomerMobile());
		q.setParameter("city", cs.getCustomerCity());
		q.setParameter("state", cs.getCustomerState());
		q.setParameter("country", cs.getCustomerCountry());
		q.setParameter("age", cs.getCustomerAge());
		q.setParameter("gender", cs.getCustomerGender());
		q.setParameter("balance", cs.getCustomerBalance());
		
		q.setParameter("id", id);
		q.executeUpdate();
		tt.commit();
		sd.close();

		return "Data is updated....";

	}
	
	// get a single record by id
	public CustomerEntity getDataById(int id) {
		
		// we are returing the customer entity.
		
		Session s = factory.openSession();
		Transaction tt = s.beginTransaction();
		
		Query sq = s.createQuery("from CustomerEntity where customerId=:id", CustomerEntity.class);
		
		sq.setParameter("id", id);
	
		CustomerEntity c = (CustomerEntity) sq.getSingleResult();
		
		tt.commit();
		
		s.close();
		
		return c;
		
	}
	
	// Get all the records
	
	public List<CustomerEntity> getAllData(){
		
		Session s = factory.openSession();
		Transaction tt = s.beginTransaction();
		
		Query<CustomerEntity> sq = s.createQuery("from CustomerEntity", CustomerEntity.class);
		
		List<CustomerEntity> list = sq.getResultList();
	
		tt.commit();
		s.close();
		
		return list;
		
	}
	
	
	

}
