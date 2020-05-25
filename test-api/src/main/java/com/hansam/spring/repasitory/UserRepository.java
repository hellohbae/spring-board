package com.hansam.spring.repasitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hansam.spring.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findByUsernameAndPassword(String username, String password);
}
