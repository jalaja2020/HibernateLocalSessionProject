package com.hcl.service;

import java.util.List;

import com.hcl.model.User;

public interface UserService {
	int saveUser(User user);
	List<User> findAllUsers();
	 void updateUser(User user);
}
