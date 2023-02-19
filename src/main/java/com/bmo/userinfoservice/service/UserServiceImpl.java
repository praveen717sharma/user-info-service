package com.bmo.userinfoservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bmo.bmomodel.model.User;
import com.bmo.userinfoservice.exception.UserAlreadyExistException;
import com.bmo.userinfoservice.exception.UserNotFoundException;
import com.bmo.userinfoservice.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	
	@Override
	public User saveUser(User user) {
		Integer id = user.getUserId();
		Optional<User> uUser = userRepo.findById(id);
		User saveUser=null;
		if (uUser.isPresent()) {
			throw new UserAlreadyExistException("User Already Exist ");
		} else {
			saveUser = userRepo.save(user);
		}
		return saveUser;
	}

	@Override
	public User getUserById(int id) {
		Optional<User> uUser=userRepo.findById(id);
		if(uUser.isPresent()) {
			return uUser.get();
		}else {
			throw new UserNotFoundException("User Not Found");
		}
	}

	@Override
	public void deleteUserById(int id) {
		
		Optional<User> uUser=userRepo.findById(id);
		if(uUser.isPresent()) {
			userRepo.delete(uUser.get());
		}else {
			throw new UserNotFoundException("User not found");
		}
	}

	@Override
	public User updateUser(User newUser) {
		
		Integer id = newUser.getUserId();
		User existingUser=null;
		
		Optional<User> oUser=userRepo.findById(id);
		if(oUser.isPresent()) {
			
			existingUser=oUser.get();
			
			existingUser.setUserId(newUser.getUserId());
			existingUser.setUserName(newUser.getUserName());
			existingUser.setUserType(newUser.getUserType());
			//existingUser.setUserAddress(newUser.getUserAddress());
		}else {
			throw new UserNotFoundException("User not found");
		}
		return newUser;
	}

}
