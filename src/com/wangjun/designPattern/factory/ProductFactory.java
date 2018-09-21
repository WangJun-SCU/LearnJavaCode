package com.wangjun.designPattern.factory;

public class ProductFactory {
	
	public static IProduct createProduct(int type) {
		
		switch(type) {
			case 1:
				return new Product1();
			case 2:
				return new Product2();
			case 3:
				return new Product3();
			case 4:
				return new Product4();
			case 5:
				return new Product5();
			default:
				System.out.println("没有此型号的产品");
				return null;
		}
	}

}
