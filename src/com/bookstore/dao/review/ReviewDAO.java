package com.bookstore.dao.review;

import javax.persistence.EntityManagerFactory;

import com.bookstore.dao.generic.JpaDAO;
import com.bookstore.entity.Review;

public class ReviewDAO extends JpaDAO<Review> implements IReview{

	public ReviewDAO(EntityManagerFactory entityManagerFactory) {
		super(entityManagerFactory);
		// TODO Auto-generated constructor stub
	}

}
