package com.konghao.eureka.consumer.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

import org.springframework.stereotype.Service;
import com.konghao.eureka.consumer.domain.Product;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager;
import com.netflix.infix.lang.infix.antlr.EventFilterParser.null_predicate_return;

@Service
public class ProductService {

	// 利用hystrix合并请求
	@HystrixCollapser(batchMethod = "batchProduct", scope = com.netflix.hystrix.HystrixCollapser.Scope.GLOBAL, collapserProperties = {
			// 请求间隔50ms之内会合并未一个请求 timerDelayInMilliseconds
			@HystrixProperty(name = "timerDelayInMilliseconds", value = "20"),
			// 设置触发批处理执行之前,在批处理中允许的最大请求数量
			@HystrixProperty(name = "maxRequestsInBatch", value = "200") })
	public Future<Product> getProduct(Integer id) {
		System.out.println("getProduct================" + id + "======================");
		return null;
	}

	@HystrixCommand
	public List<Product> batchProduct(List<Integer> ids) {
		for (Integer id : ids) {
			System.out.println(id);
		}

		List<Product> list = new ArrayList<Product>();
		list.add(new Product(1, "漫谈spring cloud与spring boot基础架构（微服务基础篇）"));
		list.add(new Product(2, "漫谈spring cloud分布式服务架构（微服务进阶篇）"));
		list.add(new Product(3, "漫谈spring cloud 与docker架构部署（微服务高级篇）"));
		list.add(new Product(4, "44444444漫谈spring cloud 与docker架构部署（微服务高级篇）"));
		return list;
	}
}
