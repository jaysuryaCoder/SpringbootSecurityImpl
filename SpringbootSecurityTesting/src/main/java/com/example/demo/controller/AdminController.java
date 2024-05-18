package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@RestController
@RequestMapping("/secure/rest")
public class AdminController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder paaEncoder;
	
	
	
	@PostMapping("/admin/add")
	public String addUserByAdmin( @RequestBody User user) {
		String password=user.getPassword();
		String encryptPwd=paaEncoder.encode(password);
		user.setPassword(encryptPwd);
		userRepository.save(user);
		return "User Addedd successfully";
	}
}
