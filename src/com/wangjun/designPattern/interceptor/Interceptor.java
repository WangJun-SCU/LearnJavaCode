package com.wangjun.designPattern.interceptor;

import java.lang.reflect.Method;

/*
 * 拦截器接口
 */
public interface Interceptor {

	public boolean before(Object proxy, Object target, Method method, Object[] args);
	
	public void around(Object proxy, Object target, Method method, Object[] args);
	
	public void after(Object proxy, Object target, Method method, Object[] args);
}
