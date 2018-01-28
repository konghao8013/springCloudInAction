package com.konghao.book.product.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.konghao.book.product.domain.Product;
import com.konghao.book.product.facade.ProductFacade;
import com.konghao.book.product.service.ProductService;

@RestController
public class ProductFacadeImpl implements ProductFacade {

	@Autowired
	private ProductService productService;

	public List<Product> findAllProduct() {
		return this.productService.findAllProduct();
	}

	public List<Product> listProduct() {
		System.out.println("###########################################");
		/*
		 * try { Thread.sleep(1*1000); } catch (InterruptedException e) { //
		 * TODO 自动生成的 catch 块 e.printStackTrace(); }
		 */
		return this.productService.findAllProduct();
	}

	@Override
	public Product getProduct(int id) {
		// TODO 自动生成的方法存根
		return this.productService.getProduct(id);
	}

	@Override
	public Product getProduct1(@RequestBody Product obj) {
		// TODO 自动生成的方法存根
		return obj;
	}

	@Override
	public Product getProduct2(int id, String name) {
		// TODO 自动生成的方法存根
		return new Product(id, name);
	}

	@Override
	public Product addProduct(@RequestBody Product obj) {
		// TODO 自动生成的方法存根
		return obj;
	}
}
