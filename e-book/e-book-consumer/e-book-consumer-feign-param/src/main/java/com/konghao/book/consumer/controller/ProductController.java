package com.konghao.book.consumer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.konghao.book.consumer.service.ProductService;
import com.konghao.book.product.domain.Product;
import com.netflix.infix.lang.infix.antlr.EventFilterParser.null_predicate_return;
import com.netflix.ribbon.proxy.annotation.Var;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public List<Product> listProduct() {
		List<Product> list = this.productService.listProduct();

		return list;
	}

	@RequestMapping(value = "get", method = RequestMethod.GET)
	public Product getProduct(@RequestParam("id") int id) {
		return this.productService.getProduct(id);
	}

	@RequestMapping(value = "get1", method = RequestMethod.POST)
	public Product getProduct1(@RequestBody Product obj) {
		// return this.productService.getProduct1(obj);
		return this.productService.addProduct(obj);
	}

	@RequestMapping(value = "get2", method = RequestMethod.GET)
	public Product getProduct2(@RequestParam("id") int id, @RequestParam("name") String name) {
		return this.productService.getProduct2(id, name);
	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public Product addProduct() {
		Product obj = new Product(2, "漫谈spring cloud分布式服务架构（微服务进阶篇）");
		return this.productService.addProduct(obj);
	}
}
