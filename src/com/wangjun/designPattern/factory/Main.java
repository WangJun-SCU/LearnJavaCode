package com.wangjun.designPattern.factory;

public class Main {

	public static void main(String[] args) {
		IProduct product1 = ProductFactory.createProduct(1);
		System.out.println("产品名：" + product1.info());
		
		IProduct product2 = ProductFactory.createProduct(2);
		System.out.println("产品名：" + product2.info());
		
		IProduct product3 = ProductFactory.createProduct(3);
		System.out.println("产品名：" + product3.info());
	}

}
