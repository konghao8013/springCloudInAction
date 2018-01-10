package com.konghao.eureka.consumer.service;

import java.util.ArrayList;
import java.util.List;

import org.bouncycastle.crypto.modes.SICBlockCipher;
import org.springframework.beans.factory.annotation.Autowired;
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

@Service
public class ProductService {
	@Autowired
	private LoadBalancerClient loadBalancerClient;// ribbon 负载均衡客户端

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			// 默认10秒,如果并发数量达到该设置值,请求会被拒绝和抛出异常并且fallback不会被调用
			/*
			 * @HystrixProperty(name = HystrixPropertiesManager.
			 * FALLBACK_ISOLATION_SEMAPHORE_MAX_CONCURRENT_REQUESTS, value =
			 * "3000")
			 */
			@HystrixProperty(name =HystrixPropertiesManager.FALLBACK_ISOLATION_SEMAPHORE_MAX_CONCURRENT_REQUESTS , value = "15"), 
			/*@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "900"), // 指定多久超时，单位毫秒。超时进fallback
*/		/*	@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), // 判断熔断的最少请求数，默认是10；只有在一个统计窗口内处理的请求数量达到这个阈值，才会进行熔断与否的判断
			@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "10"),// 判断熔断的阈值，默认值50，表示在一个统计窗口内有50%的请求处理失败，会触发熔断
*/
	})
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
}
