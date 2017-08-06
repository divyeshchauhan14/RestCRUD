package com.div.test.service;

import java.util.List;

import com.div.test.model.User;

public interface UserService {
	User findById(int userId);
	void saveUser(User user);
	void deleteUser(User user);
	void UpdateUser(User user);
	List<String> listUserProperties();
}
