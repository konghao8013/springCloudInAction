package com.konghao.book.zull.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class AccessFilter extends ZuulFilter {

	private static final Logger logger = LoggerFactory.getLogger(AccessFilter.class);

	/**
	 * 权限校验
	 **/
	@Override
	public Object run() {
		RequestContext rc = RequestContext.getCurrentContext();
		HttpServletRequest request = rc.getRequest();
		logger.info("=============pre 1=================================");
		// --"method={},url={}",request.getMethod(),request.getRequestURL().toString()
		String token = request.getParameter("token");

		if (token == null) {
			logger.warn("token is null");
			rc.setSendZuulResponse(false);// 代表请求结束，不再继续下级传递
			rc.setResponseStatusCode(401);
			rc.setResponseBody("{\"result\":\"token is null\"}");

			rc.getResponse().setContentType("text/html;charset=utf-8");
		} else {
			logger.info("token is OK");
		}

		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public boolean shouldFilter() {
		// TODO 自动生成的方法存根
		return true;
	}

	@Override
	public int filterOrder() {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public String filterType() {
		// TODO 自动生成的方法存根
		/*
		 * pre routing post error
		 **/
		return "pre";
	}

}
