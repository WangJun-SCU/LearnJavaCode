package com.wangjun.designPattern.proxy;

import java.util.HashMap;
import java.util.Map;

/*
 * 通过代理，加入缓存功能
 */
public class CachedPersonProxy implements Person {
	
	private Person person;
	private Map<Person,String> map = new HashMap<>();;
	
	public CachedPersonProxy(Person person) {
		this.person = person;
	}

	@Override
	public String getDuty() {
		String duty = map.get(person);
		if(null == duty) {
			duty = person.getDuty();
			map.put(person, duty);
		}
		return duty;
	}
}
