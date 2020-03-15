package com.hcl.dao.impl;

import java.util.List;
import java.util.Objects;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hcl.dao.IUserDao;
import com.hcl.model.User;
@Repository
public class UserDao implements IUserDao{

	@Autowired
	SessionFactory sessionFactory;

	protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }
	
	@Override
	public int addNewUser(User user) {
		getSession().persist(user);
		return Objects.nonNull(user) && Objects.nonNull(user.getUserId())?user.getUserId() :null;
	}
	public List<User> findAllUsers() {
		List<User> resultList = getSession().createQuery("from User",User.class).getResultList();
		return resultList;
	}

	@Override
	public void updateUser(User user) {
		getSession().saveOrUpdate(user);
		
	}
}
