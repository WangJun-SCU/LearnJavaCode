package com.wangjun.designPattern.abstractFactory;

public class Factory2 implements IFactory {

	@Override
	public IProduct createProduct(int type) {
		System.out.println("工厂2生产");
		if(type == 3) {
			return new Product3();
		}else if(type == 4) {
			return new Product4();
		}else {
			System.out.println("不支持此类型的产品");
		}
		return null;
	}

}
