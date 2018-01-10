package com.konghao.eureka.consumer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.konghao.eureka.consumer.domain.Product;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager;

@CacheConfig(cacheNames = "com.konghao.book")
@Service
public class ProductService {
	@Autowired
	private LoadBalancerClient loadBalancerClient;// ribbon 负载均衡客户端

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = HystrixPropertiesManager.FALLBACK_ISOLATION_SEMAPHORE_MAX_CONCURRENT_REQUESTS, value = "15"), })
	public List<Product> listProduct() {
		ServiceInstance sl = loadBalancerClient.choose("e-book-product");
		StringBuffer sb = new StringBuffer("");
		sb.append("http://");
		sb.append(sl.getHost());
		sb.append(":");
		sb.append(sl.getPort());
		sb.append("/product/list");
		System.out.println(sb.toString());
		RestTemplate rt = new RestTemplate();
		ParameterizedTypeReference<List<Product>> typeRef = new ParameterizedTypeReference<List<Product>>() {
		};
		ResponseEntity<List<Product>> resp = rt.exchange(sb.toString(), HttpMethod.GET, null, typeRef);
		List<Product> plist = resp.getBody();
		return plist;
	}

	public List<Product> fallback() {
		List<Product> list = new ArrayList<Product>();
		list.add(new Product(-1, "fallback"));
		return list;
	}

	@Cacheable(key = "'product' + #id")
	public Product get(Integer id) {
		System.out.println("=============get==================="+id);
		return new Product(id, "漫谈spring cloud分布式服务架构（微服务进阶篇）");
	} 

	@CacheEvict(key = "'product' + #id")
	public void del(Integer id) {
		System.out.println("=============del==================="+id);
	}
}
