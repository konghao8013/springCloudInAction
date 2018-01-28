package com.konghao.book.product.facade;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.LifecycleListener;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.konghao.book.product.domain.Product;

@RequestMapping("/product")
public interface ProductFacade {
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public List<Product> listProduct();

	@RequestMapping(value = "findAllProduct", method = RequestMethod.GET)
	public List<Product> findAllProduct();

	@RequestMapping(value = "get", method = RequestMethod.GET)
	public Product getProduct(@RequestParam("id") int id);

	@RequestMapping(value = "get1", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Product getProduct1(Product obj);

	@RequestMapping(value = "get2", method = RequestMethod.GET)
	public Product getProduct2(@RequestParam("id") int id, @RequestParam("name") String name);

	@RequestMapping(value = "add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Product addProduct(@RequestBody Product obj);

}
