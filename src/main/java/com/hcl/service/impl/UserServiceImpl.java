package com.hcl.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.dao.impl.UserDao;
import com.hcl.model.Stock;
import com.hcl.model.User;
import com.hcl.service.UserService;

@Service("UserService")
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
    private UserDao userDao;
	
	@Override
	public int saveUser(User user) {
		return userDao.addNewUser(user);
	}

	@Override
	public List<User> findAllUsers() {
		return userDao.findAllUsers();
	}

	@Override
	public void updateUser(User user) {
		userDao.updateUser(user);
	}

	@Override
	public int addStockCategory(Stock stock) {
		return userDao.addStockCategory(stock);
	}

}
