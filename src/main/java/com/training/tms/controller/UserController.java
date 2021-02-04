package com.training.tms.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.tms.model.AuthRequest;
import com.training.tms.model.User;
import com.training.tms.repository.UserRepository;
import com.training.tms.util.JWTUtil;

@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JWTUtil jWTUtil;
	
	@PostMapping("/authenticate")
	public String authenticate_GenerateToken(@RequestBody AuthRequest authRequest ) throws Exception {
				
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassWord()));
		} catch ( Exception e) {
			// TODO Auto-generated catch block
			throw new Exception("Invalid username/password");
			}
		return jWTUtil.generateToken(authRequest.getUserName());
	}
	
	@GetMapping("/users")
	public List<User> getUserList(){
		return userRepository.findAll();
	}
	
	@GetMapping("/")
	public String Welcome() {
		return "Welcome to TMS To do: Display Dashboard and menu bar";
	}
	
	@GetMapping("/user/{id}")
	public Optional<User> getUser(@PathVariable("id") Integer userId) {		
		return userRepository.findById(userId);
	}
}
