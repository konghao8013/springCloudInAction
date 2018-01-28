package com.konghao.book.zull.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
@Component
public class LogFilter extends ZuulFilter {

	private static final Logger logger = LoggerFactory.getLogger(LogFilter.class);

	/**
	 * 过滤器的左右打印。。。
	 * **/
	@Override
	public Object run() {
		RequestContext rc=RequestContext.getCurrentContext();
		HttpServletRequest request=rc.getRequest();
		logger.info("method={},url={}",request.getMethod(),request.getRequestURL().toString());
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
		 * pre
		 * routing
		 * post
		 * error
		 * **/
		return "pre";
	}

}
