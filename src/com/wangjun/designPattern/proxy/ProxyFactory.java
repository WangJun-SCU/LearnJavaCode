package com.wangjun.designPattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class ProxyFactory {

	private Person person;
	private Map<Person, String> map = new HashMap<>();

	public ProxyFactory(Person person) {
		this.person = person;
	}

	public Object getProxyInstance() {
		return Proxy.newProxyInstance(
				person.getClass().getClassLoader(), 
				person.getClass().getInterfaces(),
				new InvocationHandler() {

					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						String duty = map.get(person);
						if(null == duty) {
							//执行对象方法
							System.out.println("没有缓存");
							duty = (String) method.invoke(person, args);
							map.put(person, duty);
						}
						return duty;
					}
				});
	}

}
