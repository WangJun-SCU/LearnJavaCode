package com.wangjun.singleton;

public class SingletonHungaryTest {

	public static void main(String[] args) {
		
		Thread1[] Thread1Arr = new Thread1[10];
		for (int i = 0; i < Thread1Arr.length; i++) {
			Thread1Arr[i] = new Thread1();
			Thread1Arr[i].start();
		}
		
	}

}
//单例模式的饿汉实现方式--线程安全
class SingletonHungary {
	private static SingletonHungary singletonHungary = new SingletonHungary();
	//将构造器设置为private禁止通过new进行实例化
	private SingletonHungary() {
		
	}
	public static SingletonHungary getInstance() {
		return singletonHungary;
	}
}
class Thread1 extends Thread {
	@Override
	public void run() {
		System.out.println(SingletonHungary.getInstance().hashCode());
	}
}
