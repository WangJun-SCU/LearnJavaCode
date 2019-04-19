package com.wangjun.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author wangjun
 * @date 2019-03-21
 * @version 1.0
 */

@MyAnnotation(name = "test1", id = 101)
public class Test {
	
	@Check(value = "hi")
	int a;
	
	@Check("deprecation")
	public void test1() {
		Test t = new Test();
	}
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException, NoSuchMethodException {
		boolean hasMyAnnotation = Test.class.isAnnotationPresent(MyAnnotation.class);
		
		//提取类上的注解
		if(hasMyAnnotation) {
			MyAnnotation myAnnotation = Test.class.getAnnotation(MyAnnotation.class);
			System.out.println("id:" + myAnnotation.id());
			System.out.println("name:" + myAnnotation.name());
		}
		//提取成员变量上的注解
		Field a = Test.class.getDeclaredField("a");
		a.setAccessible(true);
		Check check = a.getAnnotation(Check.class);
		if(check != null) {
			System.out.println("check value=" + check.value());
		}
		
		//提取方法上的注解
		Method method = Test.class.getDeclaredMethod("test1");
		Check Check1 = method.getAnnotation(Check.class);
		if(Check1 != null) {
			System.out.println(Check1.value());
		}else {
			System.out.println(1);
		}
	}
}
