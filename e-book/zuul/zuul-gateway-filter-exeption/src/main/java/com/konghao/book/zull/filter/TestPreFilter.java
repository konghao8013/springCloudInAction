package com.konghao.book.zull.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class TestPreFilter extends ZuulFilter {

	private static final Logger logger = LoggerFactory.getLogger(TestPreFilter.class);

	/**
	 * 权限校验
	 **/
	@Override
	public Object run() {
		RequestContext rc = RequestContext.getCurrentContext();
		HttpServletRequest request = rc.getRequest();
		logger.info("=============pre 2=================================");
		// throw new RuntimeException("error");
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
		return 1;
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
