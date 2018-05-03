package com.wangjun.designPattern.decorator;

public class App {
	public static void main(String[] args) {
		//原始对象
		Person person = new Student();
		
		//装饰类对象
		Person decorator = new Decorator2(new Decorator1(person));
		decorator.function();
	}
}
