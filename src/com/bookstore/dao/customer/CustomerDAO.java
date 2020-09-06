package com.bookstore.dao.customer;

import javax.persistence.EntityManagerFactory;

import com.bookstore.dao.generic.JpaDAO;
import com.bookstore.entity.Customer;

public class CustomerDAO extends JpaDAO<Customer>{

	public CustomerDAO(EntityManagerFactory entityManagerFactory) {
		super(entityManagerFactory);
		// TODO Auto-generated constructor stub
	}

}
