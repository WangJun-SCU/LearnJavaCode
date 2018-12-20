package com.wangjun.designPattern.observer;

public class FansObserver implements Observer {
	
	private String name;
	
	public FansObserver(String name) {
		this.name = name;
	}

	@Override
	public void update(String str) {
		System.out.println(name + " 收到大V的微博发文：" + str);
	}

}
