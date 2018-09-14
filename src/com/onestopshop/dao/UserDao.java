package com.onestopshop.dao;

import java.util.List;

import com.onestopshop.model.User;

public interface UserDao {

	User getUser(long id);

	List<User> getUsers();

	int saveUser(User user);

	int updateUser(User user);

	int deleteUser(long id);

	boolean isUserExists(long id);
	
	void createUserTable();

}
