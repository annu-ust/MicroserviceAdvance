package com.example.bootsecurity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class User {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
	private boolean active;
	private String password;
	private String roles;
	@Column(name="user_name")
	private String userName;
	public User() {
		// TODO Auto-generated constructor stub
	}
	public User(int id, boolean active, String password, String roles, String userName) {
		super();
		this.id = id;
		this.active = active;
		this.password = password;
		this.roles = roles;
		this.userName = userName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}

