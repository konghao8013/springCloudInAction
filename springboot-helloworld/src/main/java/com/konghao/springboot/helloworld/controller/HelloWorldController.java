package com.konghao.springboot.helloworld.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
public class HelloWorldController {

	@Value("${konghao.msg}")
	private String msg;
	private final static Logger logger = LoggerFactory.getLogger(HelloWorldController.class);
	@RequestMapping("/hello")
	public String index() {
		//int no = 1 / 0;
		logger.info("logback 记录日志 msg:"+this.msg);
		return this.msg;
	}
}
