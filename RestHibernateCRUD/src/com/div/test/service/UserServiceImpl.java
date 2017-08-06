package com.div.test.service;

import java.util.List;

import com.div.test.dao.UserDao;
import com.div.test.dao.UserDaoImpl;
import com.div.test.model.User;

public class UserServiceImpl implements UserService {

	UserDao userDao = new UserDaoImpl();
	
	@Override
	public User findById(int userId) {
		// TODO Auto-generated method stub
		return userDao.findById(userId);
	}

	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		userDao.saveUser(user);
	}

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		userDao.deleteUser(user);
	}

	@Override
	public void UpdateUser(User user) {
		// TODO Auto-generated method stub
		userDao.updateUser(user);
	}

	@Override
	public List<String> listUserProperties() {
		// TODO Auto-generated method stub
		return userDao.listUserProperties();
	}

}
