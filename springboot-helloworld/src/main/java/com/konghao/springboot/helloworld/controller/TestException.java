package com.konghao.springboot.helloworld.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.konghao.springboot.helloworld.exception.BusinessException;
/**
 * 孔浩自定义异常测试
 * @author kongh
 *
 */
@RestController
public class TestException {
	@RequestMapping("advice")
	public String index() {
		throw new BusinessException("-120", "HelloWorldController.index 孔浩自定义的异常");
	
	}
}
