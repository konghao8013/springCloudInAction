package com.konghao.eureka.consumer.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.apache.catalina.LifecycleListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.konghao.eureka.consumer.domain.Product;
import com.konghao.eureka.consumer.service.ProductService;


@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "getproduct", method = RequestMethod.GET)
	public void getProduct() throws InterruptedException, ExecutionException {
		Future<Product> p1 = this.productService.getProduct(1);
		Future<Product> p2 = this.productService.getProduct(2);
		Future<Product> p3 = this.productService.getProduct(3);
		System.out.println(p1.get().toString());
		System.out.println(p2.get().toString());
		System.out.println(p3.get().toString());
	}
}
