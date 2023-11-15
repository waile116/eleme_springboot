package com.neusoft.elmboot.service;

import java.security.NoSuchAlgorithmException;

import com.neusoft.elmboot.entity.User;

public interface RestrictedUserService {
    public User getUserByIdByPass(String userId, String password) throws NoSuchAlgorithmException;

    public int updateUserPassword(String userId, String oldPass, String newPass) throws NoSuchAlgorithmException;
}
