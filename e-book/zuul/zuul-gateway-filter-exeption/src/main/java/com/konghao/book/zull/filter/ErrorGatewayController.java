package com.konghao.book.zull.filter;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorGatewayController implements ErrorController {

	@Override
	public String getErrorPath() {
		// TODO 自动生成的方法存根
		return "/error";
	}

	@RequestMapping("/error")
	public String error() {
		return "{\"result\":\"500 errorl\"}";
	}

}
