package com.konghao.eureka.consumer.controller;

import java.util.ArrayList;
import java.util.List;

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

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public List<Product> listProduct() {
		List<Product> list = this.productService.listProduct();

		return list;
	}
}
