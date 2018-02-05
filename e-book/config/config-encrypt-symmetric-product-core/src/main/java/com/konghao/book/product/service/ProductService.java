package com.konghao.book.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.konghao.book.product.domain.Product;
import com.konghao.book.product.persistence.ProductMapper;

@Service
public class ProductService {
	@Autowired
	private ProductMapper productMapper;

	public List<Product> findAllProduct() {
		return this.productMapper.findAllProduct();
	}

	public List<Product> listProduct() {
		System.out.println("###########################################");
		/*
		 * try { Thread.sleep(1*1000); } catch (InterruptedException e) { //
		 * TODO 自动生成的 catch 块 e.printStackTrace(); }
		 */
		return this.productMapper.findAllProduct();
	}

	public Product getProduct(int id) {
		// TODO 自动生成的方法存根
		return this.productMapper.selectByPrimaryKey(id);
	}
}
