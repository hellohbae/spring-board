package com.hansam.spring.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hansam.spring.entity.User;
import com.hansam.spring.repasitory.UserRepository;
import com.hansam.spring.service.UserService;

@RestController
@RequestMapping(value="/users")
public class UserController {
	
	private final UserService userService;
	//private UserRepository userRepository;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	// 사용자 username과 password을 입력받아 새로운 User를 생성하고 그 결과를 반환
    @PostMapping
    public User create(@RequestParam String username, String password) {
        return userService.join(username, password);
    }

    // 자신의 정보를 반환
    @GetMapping(value = "/me")
    public User getMe(@RequestHeader String authorization) {

        return userService.authentication(authorization);
    }

    // 자신의 비밀번호를 갱신한 뒤 그 결과를 반환
    @PutMapping(value = "/me")
    public User updatePassword(@RequestHeader String authorization, @RequestParam String password) {
        return userService.updatePassword(authorization, password);
    }

    // 탈퇴
    @DeleteMapping
    public void withdraw(@RequestHeader String authorization) {
        userService.withdraw(authorization);
    }
}
