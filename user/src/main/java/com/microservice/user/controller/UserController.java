package com.microservice.user.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.user.entities.User;
import com.microservice.user.repository.UserRepository;

@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/user/{id}")
	public User getUser(@PathVariable Integer id) {
		Optional<User> user = userRepository.findById(id);
		
		if(user.isPresent()) {
			return user.get();
		}else {
			return null;
		}
	}
	
	@GetMapping("/user")
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	@GetMapping("/user/get/{id}")
	public Integer retrieveUserId(@PathVariable Integer id) {
		Optional<User> user = userRepository.findById(id);
		
		if(user.isPresent()) {
			return user.get().getUserId();
		}else {
			return null;
		}
	}
}
