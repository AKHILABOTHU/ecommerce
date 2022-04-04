package com.ecommerce.ecart.entity.dao;

import java.util.List;

import com.ecommerce.ecart.entity.User;

public interface UserDAO {

	public List<User> findall();
	
	public User findById(long id);
	
	public void save(User user);
	
	public void  deleteById(long id);
}
