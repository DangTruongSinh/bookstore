package com.bookstore.dao.category;

import javax.persistence.EntityManagerFactory;

import com.bookstore.dao.generic.JpaDAO;
import com.bookstore.entity.Category;

public class CategoryDAO extends JpaDAO<Category>{

	public CategoryDAO(EntityManagerFactory entityManagerFactory) {
		super(entityManagerFactory);
		// TODO Auto-generated constructor stub
	}

}
