package com.konghao.book.config.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/*刷新配置文件*/
@RefreshScope
@RestController
public class TestController {
	@Value("${book.config}")
	private String msg;
	/*http://localhost:9031/refresh post访问*/
	@RequestMapping("/test")
	public String test() {
		return msg;
	}
}
