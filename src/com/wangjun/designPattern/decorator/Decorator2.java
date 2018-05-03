package com.wangjun.designPattern.decorator;

public class Decorator2 implements Person {
	
	private Person person;
	
	public Decorator2(Person person) {
		this.person = person;
	}

	@Override
	public void function() {
		System.out.println("装饰器2增加能力：音乐。");
		person.function();
	}

}
