package com.bookstore.dao.generic;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.bookstore.constant.ActionType;

public class JpaDAO<T> implements GenericDAO<T>{
	EntityManager entityManager;
	Class<T> genericClass;
	@SuppressWarnings("unchecked")
	public JpaDAO(EntityManagerFactory entityManagerFactory) {
		super();
		try {
			this.entityManager = entityManagerFactory.createEntityManager();
			Type mySuperclass = getClass().getGenericSuperclass();
			Type types = ((ParameterizedType)mySuperclass).getActualTypeArguments()[0];
			genericClass = (Class<T>) Class.forName(types.toString().split(" ")[1]);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public T create(T t) {
		actionNeedTransaction(t, ActionType.Create);
		return t;
	}

	@Override
	public T update(T t) {
		actionNeedTransaction(t, ActionType.Update);
		return t;
	}

	@Override
	public T get(int id) {
		// TODO Auto-generated method stub
		return entityManager.find(genericClass, id);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		T t = get(id);
		actionNeedTransaction(t, ActionType.Delete);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> listAll() {
		// TODO Auto-generated method stub
		return entityManager.createQuery("Select t from " + genericClass.getSimpleName() + " t").getResultList();
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return entityManager.createQuery("Select t from " + genericClass.getSimpleName() + " t").getResultList().size();
	}
	
	private void actionNeedTransaction(T t, ActionType acType) {
		entityManager.getTransaction().begin();
		if(acType == ActionType.Create) {
			entityManager.persist(t);
		}else if(acType == ActionType.Update) {
			entityManager.merge(t);
		}else if(acType == ActionType.Delete) {
			entityManager.remove(t);
		}
		entityManager.getTransaction().commit();
		entityManager.close();
	}
}
