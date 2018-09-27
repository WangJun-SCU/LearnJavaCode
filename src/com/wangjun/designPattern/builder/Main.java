package com.wangjun.designPattern.builder;

public class Main {

	public static void main(String[] args) {
		Product p = new Product(1, "htc");
		System.out.println(p.toString());

		Product2 p2 = new Product2();
		p2.setId(10);
		p2.setName("phone");
		p2.setPrice(100);
		p2.setType(1);

		Product3 p3 = new Product3.Builder()
								.id(10)
								.name("phone")
								.price(100)
								.type(1)
								.build();
	}

}
