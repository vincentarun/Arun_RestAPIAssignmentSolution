package com.greatlearning.employeemanagement.service;

import java.util.List;

import com.greatlearning.employeemanagement.model.User;

public interface UserService {

	User saveUser(User user);

	
	List<User> fetchUserList();

	
	User updateUser(User user, Integer userId);

	
	void deleteUserById(Integer userId);

	User getUser(Integer Id);
	
	}


