package com.konghao.book.product.facade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.konghao.book.product.domain.Product;
import com.konghao.book.product.facade.ProductFacade;

@RestController
public class ProductFacadeImpl implements ProductFacade {
	public List<Product> listProduct() {
		System.out.println("###########################################");
/*		try {
			Thread.sleep(1*1000);
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}*/
		List<Product> list = new ArrayList<Product>();
		list.add(new Product(1, "漫谈spring cloud与spring boot基础架构（微服务基础篇）"));
		list.add(new Product(2, "漫谈spring cloud分布式服务架构（微服务进阶篇）"));
		list.add(new Product(3, "漫谈spring cloud 与docker架构部署（微服务高级篇）"));
		return list;
	}

	@Override
	public Product getProduct(int id) {
		// TODO 自动生成的方法存根
		return new Product(id, "漫谈spring cloud分布式服务架构（微服务进阶篇）");
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
