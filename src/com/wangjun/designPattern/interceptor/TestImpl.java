package com.wangjun.designPattern.interceptor;

class TestImpl implements TestInterface {
	
	@Override
	public void sayHello() {
		System.out.println("hello...");
	}
}