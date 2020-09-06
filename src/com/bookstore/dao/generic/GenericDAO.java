package com.bookstore.dao.generic;

import java.util.List;

public interface GenericDAO<T> {
	T create(T t);
	T update(T t);
	T get(int id);
	void delete(int id);
	List<T> listAll();
	long count();
}
