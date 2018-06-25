package com.wangjun.othersOfJava;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class LambdaTest {
	
	public static void printStr(String str) {
		System.out.println(str);
	}
	
	public static void main(String[] args) {
		
		// 带类型
		Animal a1 = (String str) -> {
			System.out.println("狗狗吃饭:" + str);
		};
		// 不带类型
		Animal a2 = (str) -> {
			System.out.println("狗狗吃饭:" + str);
		};
		// 不带括号
		Animal a3 = str -> {
			System.out.println("狗狗吃饭:" + str);
		};
		// 不带大括号
		Animal a4 = str -> System.out.println("狗狗吃饭:" + str);
		a1.eat("火腿肠");
		a2.eat("牛肉");
		a3.eat("面条");
		a4.eat("米饭");
		
		// 使用return返回
		Person p1 = () -> {
			return "老师的职责：教书育人!";
		};
		// 直接返回
		Person p2 = () -> "医生的职责：救死扶伤!";
		System.out.println(p1.duty());
		System.out.println(p2.duty());
		
		List<String> list = Arrays.asList("aaa","bbb","ccc");
		// 通常的遍历方式
		for(String str: list) {
			LambdaTest.printStr(str);
		}
		// 使用Lambda表达式遍历
		list.forEach(str -> {
			LambdaTest.printStr(str);
		});
		// 使用::遍历
		list.forEach(LambdaTest::printStr);
		// 下面的方法和上面等价，使用的是函数式编程
        Consumer<String> methodParam = LambdaTest::printStr; //方法参数
        list.forEach(x -> methodParam.accept(x));//方法执行accept
	}
	
	// 没有返回值
	interface Animal {
		public void eat(String str);
	}
	// 有返回值
	interface Person {
		public String duty();
	}
}
