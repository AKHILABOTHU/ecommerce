package com.ecommerce.ecart.entity.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ecommerce.ecart.entity.User;

@Repository
public class UserDAOImpl implements UserDAO{

	//define fields for entity manager
	
	private EntityManager entityManager;
	
	// setup constructor injection
	@Autowired
	public UserDAOImpl(EntityManager theEntityManager)
	{
		entityManager = theEntityManager;
	}
	
	
	@Override
	public List<User> findall() {
		// TODO Auto-generated method stub
		//get the current hibernate session
		Session curreSession = entityManager.unwrap(Session.class);
		//create query 
		Query<User> query = curreSession.createQuery("from User", User.class);
		//execute query and get result
		List<User> users = query.getResultList();
		//return the result
		return users;
	}


	@Override
	public User findById(long id) {
		// TODO Auto-generated method stub
		//get the current hibernate session
				Session curreSession = entityManager.unwrap(Session.class);
				//create query 
				User user = curreSession.get(User.class,id);
				
				//return the result
				return user;
	}


	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		//get the current hibernate session
		Session curreSession = entityManager.unwrap(Session.class);
		//save user
		curreSession.saveOrUpdate(user);
	}


	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		//get the current hibernate session
		Session curreSession = entityManager.unwrap(Session.class);
		//create query 
		Query query = curreSession.createQuery("Delete from User where userId=:userId");
		query.setParameter("userId", id);
		query.executeUpdate();
		
	
	}

}
