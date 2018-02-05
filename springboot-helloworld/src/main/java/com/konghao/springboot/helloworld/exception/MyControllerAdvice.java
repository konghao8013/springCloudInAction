package com.konghao.springboot.helloworld.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class MyControllerAdvice {
	/**
	 * 全局捕获异常，只要作用在@questMapping方法上所有的异常信息都会被捕获到
	 * @param ex
	 * @return
	 */
	@ResponseBody
	@ExceptionHandler(value = Exception.class)
	public Map<String, Object> errorHandler(Exception ex) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", -1);
		map.put("msg", ex.getMessage());
		map.put("StackTrace", ex.getStackTrace()[0]);
		map.put("class", ex.getClass());
		return map;
	}
	
	@ResponseBody
	@ExceptionHandler(value = BusinessException.class)
	public Map<String, Object> errorHandler(BusinessException ex) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", ex.getCode());
		map.put("msg", ex.getMsg());
		map.put("StackTrace", ex.getStackTrace()[0]);
		map.put("class", ex.getClass());
		return map;
	}
}
