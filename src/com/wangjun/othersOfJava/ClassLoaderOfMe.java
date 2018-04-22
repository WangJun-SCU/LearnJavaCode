package com.wangjun.othersOfJava;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/*
 * 验证不同的类加载器对instanceof关键字运算结果的影响
 */
public class ClassLoaderOfMe {
	
	public ClassLoaderOfMe() {
		System.out.println("11111");
	}

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		ClassLoader myloader = new ClassLoader() {
			public java.lang.Class<?> loadClass(String name) throws ClassNotFoundException {
				try {
					String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
					//System.out.println(fileName);
					InputStream is = getClass().getResourceAsStream(fileName);
					System.out.println("is:" + is);
					if(null == is) {
						return super.loadClass(name);
					}
					byte[] b = new byte[is.available()];
					System.out.println("is::" + is.available());
					is.read(b);
					return defineClass(name, b, 0, b.length);
				} catch (IOException e) {
					e.printStackTrace();
					throw new ClassNotFoundException(name);
				}
			};
		};
		
		Object obj = myloader.loadClass("com.wangjun.othersOfJava.ClassLoaderOfMe").newInstance();
		System.out.println(obj.getClass());
		System.out.println(obj instanceof com.wangjun.othersOfJava.ClassLoaderOfMe);
	}

}
