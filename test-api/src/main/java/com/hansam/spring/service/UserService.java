package com.hansam.spring.service;

import com.hansam.spring.entity.User;

public interface UserService {

	User join(String username, String password);
	User authentication(String token);
	User updatePassword(String token, String password);
	void withdraw(String token);
}
