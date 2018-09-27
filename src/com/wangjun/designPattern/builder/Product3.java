package com.wangjun.designPattern.builder;

public class Product3 {
	
	private final int id;
	private final String name;
	private final int type;
	private final float price;
	
	private Product3(Builder builder) {
		this.id = builder.id;
		this.name = builder.name;
		this.type = builder.type;
		this.price = builder.price;
	}
	
	public static class Builder {
		private int id;
		private String name;
		private int type;
		private float price;
		
		public Builder id(int id) {
			this.id = id;
			return this;
		}
		public Builder name(String name) {
			this.name = name;
			return this;
		}
		public Builder type(int type) {
			this.type = type;
			return this;
		}
		public Builder price(float price) {
			this.price = price;
			return this;
		}
		
		public Product3 build() {
			return new Product3(this);
		}
	}

}
