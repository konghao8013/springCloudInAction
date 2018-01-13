package com.konghao.book.consumer.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.konghao.book.consumer.hystrix.ProductServiceFallbackFactory;
import com.konghao.book.product.domain.Product;
import com.konghao.book.product.facade.ProductFacade;
@FeignClient(name = "e-book-product", fallbackFactory = ProductServiceFallbackFactory.class)
public interface ProductService {

	
	@RequestMapping(value = "product/list", method = RequestMethod.GET)
	public List<Product> listProduct();
}
