package com.bookstore.dao.user;

import javax.persistence.EntityManagerFactory;

import com.bookstore.dao.generic.JpaDAO;
import com.bookstore.entity.Users;

public class UserDAO extends JpaDAO<Users> implements IUserDAO{

	public UserDAO(EntityManagerFactory entityManagerFactory) {
		super(entityManagerFactory);
		// TODO Auto-generated constructor stub
	}

}
