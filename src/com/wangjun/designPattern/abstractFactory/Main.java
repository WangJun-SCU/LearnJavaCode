package com.wangjun.designPattern.abstractFactory;

public class Main {

	public static void main(String[] args) {
		IProduct product1 = ProductFactory.createProduct(1);
		System.out.println("产品名：" + product1.info());
		
		IProduct product2 = ProductFactory.createProduct(4);
		System.out.println("产品名：" + product2.info());
		
		IProduct product3 = ProductFactory.createProduct(5);
		System.out.println("产品名：" + product3.info());
	}

}
