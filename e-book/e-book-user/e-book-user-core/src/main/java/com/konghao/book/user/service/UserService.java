package com.konghao.book.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.konghao.book.user.persistence.UserMapper;

@Service
public class UserService {

	@Autowired
	UserMapper userMapper;

	public Integer Login(String userName, String password) {

		return userMapper.Login(userName, password);
	}
}
