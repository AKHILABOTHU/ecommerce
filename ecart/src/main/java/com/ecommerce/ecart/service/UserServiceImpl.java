package com.ecommerce.ecart.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.ecart.entity.User;
import com.ecommerce.ecart.entity.dao.UserDAO;

@Repository
public class UserServiceImpl implements UserService{

	
	private UserDAO userDAO;
	
	@Autowired
	public UserServiceImpl(UserDAO theUserDAO) {
		userDAO=theUserDAO;
	}
	
	
	@Override
	@Transactional
	public List<User> findall() {
		// TODO Auto-generated method stub
		return userDAO.findall();
	}

	@Override
	@Transactional
	public User findById(long id) {
		// TODO Auto-generated method stub
		return userDAO.findById(id);
	}

	@Override
	@Transactional
	public void save(User user) {
		// TODO Auto-generated method stub
		userDAO.save(user);
		
	}

	@Override
	@Transactional
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		userDAO.deleteById(id);
		
	}

	

}
