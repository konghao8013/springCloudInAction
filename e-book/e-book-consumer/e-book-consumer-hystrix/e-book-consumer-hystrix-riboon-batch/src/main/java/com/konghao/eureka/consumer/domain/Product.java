package com.konghao.eureka.consumer.domain;

public class Product {
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + "]";
	}

	public Product(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Product() {
		super();
		// TODO 自动生成的构造函数存根
	}

	private Integer id;
	private String name;

	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
