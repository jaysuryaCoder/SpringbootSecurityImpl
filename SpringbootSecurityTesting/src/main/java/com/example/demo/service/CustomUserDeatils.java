package com.example.demo.service;

import java.util.Collection;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.model.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomUserDeatils implements UserDetails {
	
	private User user;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		user.getRoles().stream().map(role-> new SimpleGrantedAuthority("ROLE_"+ role)).collect(Collectors.toList());
		return null;
	}

	@Override
	public String getPassword() {
	 
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
