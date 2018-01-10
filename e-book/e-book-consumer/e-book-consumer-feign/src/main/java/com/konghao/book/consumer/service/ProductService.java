package com.konghao.book.consumer.service;


import org.springframework.cloud.netflix.feign.FeignClient;

import com.konghao.book.product.facade.ProductFacade;

@FeignClient(name="e-book-product")
public interface ProductService extends ProductFacade {
	
}
