package com.wangjun.jvm;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 反射操作练习
 *通过反射可以获取：
 *1. 类对象
 *2. 类的构造器
 *3. 类的实例
 *4. 类的Filed
 *5. 类的方法
 *
 *通过反射还可以越过泛型检查。泛型用在编译期，编译过后泛型擦除（消失掉）。
 */
public class ReflectClass {

	public static void main(String[] args) throws Exception{
		//获取class对象的三种方式-------------------------------------
		Class classStudent1 = Student.class;//第一种
		Student s1 = new Student("wangjun", 25);
		Class classStudent2 = s1.getClass();//第二种
		//常用这种
		Class classStudent3 = Class.forName("com.wangjun.jvm.Student");//第三种
		//判断三种方式得到的Class是否是同一个
		System.out.println(classStudent1 == classStudent2);
		System.out.println(classStudent3 == classStudent2);
		
		//通过反射获取构造函数并使用-------------------------------------
		//1. 获取所有“公共”构造方法
		Constructor[] constructors = classStudent3.getConstructors();
		System.out.println("所有公有的构造方法：");
		for(Constructor con: constructors) {
			System.out.println(con);
		}
		//2. 获取所有构造方法（包括公有，私有）
		Constructor[] constructors2 = classStudent3.getDeclaredConstructors();
		System.out.println("所有构造方法：");
		for(Constructor con: constructors2) {
			System.out.println(con);
		}
		//3. 获取公有、无参的构造方法
		Constructor constructor1 = classStudent3.getConstructor(null);
		//调用构造方法
		Object obj1 = constructor1.newInstance();
		//4. 获取私有，有参的构造方法
		Constructor constructor2 = classStudent3.getDeclaredConstructor(int.class);
		constructor2.setAccessible(true);//暴力访问，忽略掉修饰符，不加这一句，后面访问s2.getAge()会报权限错误
		Object obj2 = constructor2.newInstance(10);
		Student s2 = (Student)obj2;
		System.out.println(s2.getAge());
		
		//通过反射获取Field-------------------------------------
		Field[] fields1 = classStudent3.getFields();//获取所有公有字段
		Field[] fields2 = classStudent3.getDeclaredFields();//获取所有字段
		Field field1 = classStudent3.getField("address");//获取公有字段
		System.out.println(field1);
		Field field2 = classStudent3.getDeclaredField("name");//获取任意字段
		field2.setAccessible(true); //暴力访问，解除私有限定,否则field2.set(obj3, "hehe")会报错
		Object obj3 = classStudent3.newInstance();
		field2.set(obj3, "hehe");
		Student s3 = (Student)obj3;
		System.out.println(s3.getName());
		
		//通过反射获取方法-------------------------------------
		Method[] methods1 = classStudent3.getMethods();
		Method[] methods2 = classStudent3.getDeclaredMethods();
		Method method1 = classStudent3.getMethod("eat", null);
		Method method2 = classStudent3.getDeclaredMethod("run", String.class);
		Method method3 = classStudent3.getMethod("eatStatic", null);
		method3.invoke(null, null);//调用静态方法时，Object传入null
		Object obj4 = classStudent3.newInstance();
		method2.setAccessible(true);
		method2.invoke(obj4, "xiaoming");//调用方法
		
		//通过反射越过泛型检查-------------------------------------
		List<String> list = new ArrayList<>();
		list.add("aaa");
		list.add("bbb");
		//list.add(100);  编译报错
		Class listClass = list.getClass();
		Method addMethod = listClass.getMethod("add", Object.class);
		addMethod.invoke(list, 100);
		for(Object o: list) {
			System.out.println(o);
		}
	}
	
}
