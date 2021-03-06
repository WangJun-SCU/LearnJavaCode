package com.wangjun.othersOfJava;

import java.util.HashSet;
import java.util.Iterator;

/** 
 * HashSet的增删遍历
 * @author wangjun 
 * @email  scuwangjun@hotmail.com
 * @time   2018年4月6日 下午2:40:33 
 */
public class HashSetOperation {

	public static void main(String[] args) {
		//初始化
		HashSet<String> set = new HashSet<>();
		//增
		set.add("key1");
		set.add("key2");
		set.add("key3");
		//删
		set.remove("key1");
		//遍历1
		//使用set.descendingIterator()方法可以反向遍历
		System.out.println("HashSet遍历1,使用Iterator:");
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		//遍历2
		System.out.println("HashSet遍历2,使用for：");
		for(String str: set) {
			System.out.println(str);
		}
	}

}
