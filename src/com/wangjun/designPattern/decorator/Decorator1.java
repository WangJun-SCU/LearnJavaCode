package com.wangjun.designPattern.decorator;

public class Decorator1 implements Person {
	
	private Person person;
	
	public Decorator1(Person person) {
		this.person = person;
	}

	@Override
	public void function() {
		System.out.println("装饰器1增加功能：体育能力。");
		person.function();
	}

}
