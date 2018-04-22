package com.wangjun.jvm;

public class Student {
	
	public String address;
	private String name;
	private int age;
	
	public Student() {
		this.name = "name";
		this.age  = 100;
	}
	
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	private Student(int age) {
		this.age = age;
	}
	
	public void eat() {
		System.out.println("学生在食堂吃饭。");
	}
	
	private void run(String str) {
		System.out.println(str + "学生在跑步。");
	}
	
	public static void eatStatic() {
		System.out.println("静态吃饭的方法");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	

}
