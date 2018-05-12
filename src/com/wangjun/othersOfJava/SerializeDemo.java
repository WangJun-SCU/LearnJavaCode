package com.wangjun.othersOfJava;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializeDemo {

	public static void main(String[] args) {
		Employee em = new Employee();
		em.name = "wangjun";
		em.age = 24;
		em.ssh = 123456;
		// 将对象序列化后保存到文件
		try (
				FileOutputStream fo = new FileOutputStream("tem.ser");
				ObjectOutputStream oo = new ObjectOutputStream(fo))
		{
			oo.writeObject(em);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 反序列化取出对象
		Employee.local = "earth2";
		try(
				FileInputStream fi = new FileInputStream("tem.ser");
				ObjectInputStream oi = new ObjectInputStream(fi)) 
		{
			Employee e2 = (Employee) oi.readObject();
			System.out.println(e2.name);
			System.out.println(e2.age);
			System.out.println(e2.ssh);
			System.out.println(Employee.local);
			e2.test();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static class Employee implements Serializable {
		private static final long serialVersionUID = 1L;
		String name;
		int age;
		static String local = "earth";
		transient int ssh;
		String test;

		public void test() {
			System.out.println("this is test method!");
		}
	}

}
