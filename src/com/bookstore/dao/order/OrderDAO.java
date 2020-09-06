package com.bookstore.dao.order;

import javax.persistence.EntityManagerFactory;

import com.bookstore.dao.generic.JpaDAO;
import com.bookstore.entity.BookOrder;

public class OrderDAO extends JpaDAO<BookOrder> implements IOrderDAO{

	public OrderDAO(EntityManagerFactory entityManagerFactory) {
		super(entityManagerFactory);
		// TODO Auto-generated constructor stub
	}

}
