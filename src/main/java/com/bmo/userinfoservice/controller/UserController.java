package com.bmo.userinfoservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bmo.bmomodel.model.User;
import com.bmo.userinfoservice.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("user")
	public ResponseEntity<User> saveUser(@RequestBody User user){
		
		User uUser= userService.saveUser(user);
		return new ResponseEntity<User>(uUser, HttpStatus.CREATED);
	}
	
	@GetMapping("user/{id}")
	public ResponseEntity<User> getUser(@PathVariable("id") Integer userId){
		
		User user = userService.getUserById(userId);
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	
	@DeleteMapping("user/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") Integer userId){
		userService.deleteUserById(userId);
		return new ResponseEntity<String>("Deleted", HttpStatus.OK);
	}
	
	@PutMapping("user")
	public ResponseEntity<User> updateUser(@RequestBody User user){
		User uUser = userService.updateUser(user);
		return new ResponseEntity<User>(uUser, HttpStatus.OK);
	}
}
