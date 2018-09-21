package com.wangjun.designPattern.interceptor;

public class Test {

	public static void main(String[] args) {
		//拦截器
		String interceptor = "com.wangjun.designPattern.interceptor.MyInterceptor";
		//获取代理对象
		TestInterface proxy = (TestInterface) IntercepetorJdkProxy.bind(new TestImpl(), interceptor);
		//通过代理对象执行被代理对象的方法
		proxy.sayHello();
	}
}

