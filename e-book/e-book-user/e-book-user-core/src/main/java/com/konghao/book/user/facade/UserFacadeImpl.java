package com.konghao.book.user.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.konghao.book.user.service.UserService;

@RestController
public class UserFacadeImpl implements UserFacade {

	@Autowired
	private UserService userServer;

	@Override
	public Integer login(String userName, String password) {

		return userServer.Login(userName, password);
	}

}
