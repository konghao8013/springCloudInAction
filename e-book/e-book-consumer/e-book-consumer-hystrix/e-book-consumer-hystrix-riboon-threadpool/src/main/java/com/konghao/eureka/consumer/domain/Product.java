package com.konghao.eureka.consumer.domain;

public class Product {
	public Product(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Product() {
		super();
		// TODO 自动生成的构造函数存根
	}

	private int id;
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
