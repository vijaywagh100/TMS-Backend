package com.training.tms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.tms.model.User;
import com.training.tms.repository.UserRepository;

@RestController
@RequestMapping("/api/v1/")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/users")
	public List<User> getUserList(){
		return userRepository.findAll();
	}
	
	@GetMapping("/user/{id}")
	public User getUser(@PathVariable (value="id") int userId) {
		return userRepository.getOne(userId);
	}
}
