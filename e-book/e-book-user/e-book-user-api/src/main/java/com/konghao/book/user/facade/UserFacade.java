package com.konghao.book.user.facade;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.LifecycleListener;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/user")
public interface UserFacade {
	

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public Integer login(@RequestParam("userName") String userName, @RequestParam("password") String password);


}
