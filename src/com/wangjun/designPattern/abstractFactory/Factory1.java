package com.wangjun.designPattern.abstractFactory;

public class Factory1 implements IFactory {

	@Override
	public IProduct createProduct(int type) {
		System.out.println("工厂1生产");
		if(type == 1) {
			return new Product1();
		}else if(type == 2) {
			return new Product2();
		}else {
			System.out.println("不支持此类型的产品");
		}
		return null;
	}

}
