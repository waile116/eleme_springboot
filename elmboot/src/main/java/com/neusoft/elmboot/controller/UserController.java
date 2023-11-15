package com.neusoft.elmboot.controller;

import com.neusoft.elmboot.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.neusoft.elmboot.entity.User;
import com.neusoft.elmboot.service.RestrictedUserService;
import com.neusoft.elmboot.service.UserService;

import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	private RestrictedUserService restrictedUserService;

	@GetMapping("/getByIdByPass")
	public User getUserByIdByPass(String userId, String password) throws NoSuchAlgorithmException {
		password = CommonUtil.encodePassword(password);
		return restrictedUserService.getUserByIdByPass(userId, password);
	}

	@GetMapping("/getById")
	public int getUserById(String userId) {
		return userService.getUserById(userId);
	}

	@PostMapping("/save")
	public int saveUser(User user) throws NoSuchAlgorithmException {
		String password = user.getPassword();
		password = CommonUtil.encodePassword(password);
		user.setPassword(password);
		return userService.saveUser(user);
	}

	@PutMapping("/updateMsg")
	public int updateUserMsg(String userId, String username) {
		return userService.updateUserMsg(userId, username);
	}

	@PutMapping("/updatePassword")
	public int updateUserPassword(String userId, String oldPass, String newPass) throws NoSuchAlgorithmException {
		oldPass = CommonUtil.encodePassword(oldPass);
		newPass = CommonUtil.encodePassword(newPass);
		return restrictedUserService.updateUserPassword(userId, oldPass, newPass);
	}
}
