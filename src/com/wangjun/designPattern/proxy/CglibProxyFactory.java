package com.wangjun.designPattern.proxy;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/*
 * cglib代理工厂
 * 对Doctor在内存中动态构建一个子类对象
 */
public class CglibProxyFactory implements MethodInterceptor {

	private Object person;
	private Map<Object, String> map = new HashMap<>();

	public CglibProxyFactory(Object person) {
		this.person = person;
	}

	// 给目标对象创建一个代理对象
	public Object getProxyInstance() {
		// 1.工具类
		Enhancer en = new Enhancer();
		// 2.设置父类
		en.setSuperclass(person.getClass());
		// 3.设置回调函数
		en.setCallback(this);
		// 4.创建子类(代理对象)
		return en.create();
	}

	@Override
	public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
		String duty = map.get(person);
		if(null == duty) {
			//执行目标对象的方法
			System.out.println("cglib实现，有缓存");
			duty = (String) arg1.invoke(person, arg2);
			map.put(person, duty);
		}
		return duty;
	}

}
