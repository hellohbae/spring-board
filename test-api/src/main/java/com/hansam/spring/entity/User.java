package com.hansam.spring.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String username;
	private String password;
	
	protected User() {}
	
	public User(String name, String password) {
		this.username = name;
		this.password = password;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return username;
	}
	
	public void setName(String username) {
        this.username = username;
    }
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

    @Override
    public String toString() {
        return String.format("User[id='%d', name='%s']", id, username);
    }
}
