package com.wangjun.designPattern.interceptor;

import java.lang.reflect.Method;

public class MyInterceptor implements Interceptor {

	/*
	 * @return true:调用代理对象的方法，不调用around方法；false:调用around不调用被代理对象的方法
	 */
	@Override
	public boolean before(Object proxy, Object target, Method method, Object[] args) {
		System.out.println("before方法调用");
		return true;
	}

	@Override
	public void around(Object proxy, Object target, Method method, Object[] args) {
		System.out.println("取代了被代理对象的方法");
	}

	@Override
	public void after(Object proxy, Object target, Method method, Object[] args) {
		System.out.println("after方法调用");
	}

}
