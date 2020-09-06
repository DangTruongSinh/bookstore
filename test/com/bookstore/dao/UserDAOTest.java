package com.bookstore.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.bookstore.dao.user.IUserDAO;
import com.bookstore.dao.user.UserDAO;
import com.bookstore.entity.Users;

class UserDAOTest {
	
	static EntityManagerFactory entityManagerFactory;
	static IUserDAO iUserDAO;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
		iUserDAO = new UserDAO(entityManagerFactory);
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		entityManagerFactory.close();
	}

	@Test
	void create() {
		Users users = new Users("sinh@gmail.com", "1234", "dang truong sinh");
		Users userResult = iUserDAO.create(users);
		assertNotNull(userResult);
	}
	@Test
	void update() {
		Users users = new Users("sinh123@gmail.com", "1234", "dang truong sinh");
		users.setUserId(20);
		Users userResult = iUserDAO.update(users);
		assertNotNull(userResult);
	}
	@Test
	void get() {
		assertNotNull(iUserDAO.get(20));
	}
	@Test
	void count() {
		assertEquals(iUserDAO.count(), 5);
	}
}
