package com.wangjun.singleton;

public class SingletonLazyTest {

	public static void main(String[] args) {

		Thread2[] ThreadArr = new Thread2[10];
		for (int i = 0; i < ThreadArr.length; i++) {
			ThreadArr[i] = new Thread2();
			ThreadArr[i].start();
		}

	}

}

// 测试线程
class Thread2 extends Thread {
	@Override
	public void run() {
		System.out.println(SingletonLazy5.getInstance().hashCode());
	}
}

// 单例模式的懒汉实现1--线程不安全
class SingletonLazy1 {
	private static SingletonLazy1 singletonLazy;

	private SingletonLazy1() {

	}

	public static SingletonLazy1 getInstance() {
		if (null == singletonLazy) {
			try {
				// 模拟在创建对象之前做一些准备工作
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			singletonLazy = new SingletonLazy1();
		}
		return singletonLazy;
	}
}

// 单例模式的懒汉实现2--线程安全
// 通过设置同步方法，效率太低，整个方法被加锁
class SingletonLazy2 {
	private static SingletonLazy2 singletonLazy;

	private SingletonLazy2() {

	}

	public static synchronized SingletonLazy2 getInstance() {
		try {
			if (null == singletonLazy) {
				// 模拟在创建对象之前做一些准备工作
				Thread.sleep(1000);
				singletonLazy = new SingletonLazy2();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return singletonLazy;
	}
}

// 单例模式的懒汉实现3--线程安全
// 通过设置同步代码块，效率也太低，整个代码块被加锁
class SingletonLazy3 {

	private static SingletonLazy3 singletonLazy;

	private SingletonLazy3() {

	}

	public static SingletonLazy3 getInstance() {
		try {
			synchronized (SingletonLazy3.class) {
				if (null == singletonLazy) {
					// 模拟在创建对象之前做一些准备工作
					Thread.sleep(1000);
					singletonLazy = new SingletonLazy3();
				}
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		return singletonLazy;
	}
}

// 单例模式的懒汉实现4--线程不安全
// 通过设置同步代码块，只同步创建实例的代码
//但是还是有线程安全问题
class SingletonLazy4 {

	private static SingletonLazy4 singletonLazy;

	private SingletonLazy4() {

	}

	public static SingletonLazy4 getInstance() {
		try {
			if (null == singletonLazy) {
				// 模拟在创建对象之前做一些准备工作
				Thread.sleep(1000);
				synchronized (SingletonLazy4.class) {
					singletonLazy = new SingletonLazy4();
				}
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		return singletonLazy;
	}
}
//单例模式的懒汉实现5--线程安全
//通过设置同步代码块，使用DCL双检查锁机制
//使用双检查锁机制成功的解决了单例模式的懒汉实现的线程不安全问题和效率问题
//DCL 也是大多数多线程结合单例模式使用的解决方案
class SingletonLazy5 {

	private static volatile SingletonLazy5 singletonLazy;

	private SingletonLazy5() {

	}

	public static SingletonLazy5 getInstance() {
		try {
			if (null == singletonLazy) {
				// 模拟在创建对象之前做一些准备工作
				Thread.sleep(1000);
				synchronized (SingletonLazy5.class) {
					if(null == singletonLazy) {
						singletonLazy = new SingletonLazy5();
					}
				}
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		return singletonLazy;
	}
}
