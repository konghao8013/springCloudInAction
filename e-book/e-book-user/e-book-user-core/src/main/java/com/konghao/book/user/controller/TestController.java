package com.konghao.book.user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	@RequestMapping("/test")

	public String test() {
		return "这是孔浩的测试";
	}
}
