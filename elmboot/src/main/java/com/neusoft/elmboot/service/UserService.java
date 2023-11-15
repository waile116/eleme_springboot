package com.neusoft.elmboot.service;

import com.neusoft.elmboot.dto.RegisterUserInfo;
import com.neusoft.elmboot.exception.UsernamePasswordNotMatchException;
import com.neusoft.elmboot.exception.UsernameUserIdRepeatedException;
import com.neusoft.elmboot.entity.User;

import java.security.NoSuchAlgorithmException;

public interface UserService {

    public int getUserById(String userId);

    public int saveUser(User user) throws NoSuchAlgorithmException;

    public int updateUserMsg(String userId, String username);

    String login(String username, String password) throws UsernamePasswordNotMatchException;

    String register(RegisterUserInfo user) throws UsernameUserIdRepeatedException;

}
