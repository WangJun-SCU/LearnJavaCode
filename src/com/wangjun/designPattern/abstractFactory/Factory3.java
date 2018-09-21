package com.wangjun.designPattern.abstractFactory;

public class Factory3 implements IFactory {

	@Override
	public IProduct createProduct(int type) {
		System.out.println("工厂3生产");
		if(type == 5) {
			return new Product5();
		}else if(type == 6) {
			return new Product6();
		}else {
			System.out.println("不支持此类型的产品");
		}
		return null;
	}

}
