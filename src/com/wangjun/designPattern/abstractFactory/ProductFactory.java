package com.wangjun.designPattern.abstractFactory;

public class ProductFactory {
	
	public static IProduct createProduct(int type) {
		IFactory factory = null;
		
		//1,2类型使用工厂1生成；3,4类型使用工厂2生产；5,6类型使用工厂3生产
		if(type >= 1 && type <= 2) {
			factory = new Factory1();
		}else if(type >=3 && type <= 4) {
			factory = new Factory2();
		}else if(type >= 5 && type <= 6) {
			factory = new Factory3();
		}else {
			System.out.println("不支持此类型的产品");
			return null;
		}
		
		IProduct product = factory.createProduct(type);
		
		return product;
	}

}
