package com.bookstore.dao.book;

import javax.persistence.EntityManagerFactory;

import com.bookstore.dao.generic.JpaDAO;
import com.bookstore.entity.Book;

public class BookDAO extends JpaDAO<Book> implements IBookDAO{

	public BookDAO(EntityManagerFactory entityManagerFactory) {
		super(entityManagerFactory);
		// TODO Auto-generated constructor stub
	}

}
