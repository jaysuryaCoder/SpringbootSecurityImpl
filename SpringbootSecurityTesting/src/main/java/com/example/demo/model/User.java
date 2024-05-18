package com.example.demo.model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class User {
	@Id
	private int user_id;
	private String username;
	private String password;
	private String email;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name="user_role",joinColumns = @JoinColumn(name="user_id"),inverseJoinColumns = @JoinColumn(name="role_id"))
	private Set<Role> roles;
	
}
