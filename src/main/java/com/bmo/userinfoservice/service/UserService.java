package com.bmo.userinfoservice.service;

import com.bmo.bmomodel.model.User;

public interface UserService {

	public abstract User saveUser(User user);
	
	public abstract User getUserById(int id);
	
	public abstract  void deleteUserById(int id);
	
	public abstract User updateUser(User user);
}
