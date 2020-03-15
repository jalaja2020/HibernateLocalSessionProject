package com.hcl.dao;

import java.util.List;

import com.hcl.model.User;

public interface IUserDao {
	int addNewUser(User user);
	List<User> findAllUsers();
	 void updateUser(User user);
}
