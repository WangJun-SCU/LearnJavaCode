package com.wangjun.designPattern.proxy;

public class Main {

	public static void main(String[] args) {
		Person teacher = new Teacher();
		System.out.println(teacher.getClass());

		// 使用静态代理
		CachedPersonProxy proxy = new CachedPersonProxy(teacher);
		System.out.println(proxy.getDuty());

		// 使用动态代理
		ProxyFactory proxyFactory = new ProxyFactory(teacher);
		Person teacherProxy = (Person) proxyFactory.getProxyInstance();
		System.out.println(teacherProxy.getClass());
		System.out.println(teacherProxy.getDuty());
		System.out.println(teacherProxy.getDuty());

		// 使用cglib
		// 目标对象
		Doctor target = new Doctor();
		System.out.println(target.getClass());
		// 代理对象
		Doctor proxyCglib = (Doctor) new CglibProxyFactory(target).getProxyInstance();
		// 执行代理对象的方法
		System.out.println(proxyCglib.getClass());
		System.out.println(proxyCglib.getDuty());
		System.out.println(proxyCglib.getDuty());
	}

}
