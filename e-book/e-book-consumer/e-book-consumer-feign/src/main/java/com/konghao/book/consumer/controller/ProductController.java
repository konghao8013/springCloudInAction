package com.konghao.book.consumer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.konghao.book.consumer.service.ProductService;
import com.konghao.book.product.domain.Product;

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
