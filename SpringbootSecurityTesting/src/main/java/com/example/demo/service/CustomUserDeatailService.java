package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

public class CustomUserDeatailService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user= userRepository.findByUsername(username);
		CustomUserDeatils userDeatil = null;
		
		if(user != null) {
			userDeatil= new CustomUserDeatils();
			userDeatil.setUser(user);
		}else {
			throw new UsernameNotFoundException("user not exists with this name  "+username);
		}
		return null;
	}

}
