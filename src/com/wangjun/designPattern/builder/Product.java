package com.wangjun.designPattern.builder;

public class Product {
	
	private int id;
	private String name;
	private int type;
	private float price;
	
	public Product() {
		super();
	}
	
	public Product(int id) {
		super();
		this.id = id;
	}

	public Product(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Product(int id, String name, int type) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
	}

	public Product(int id, String name, int type, float price) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", type=" + type + ", price=" + price + "]";
	}

}
