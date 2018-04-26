package com.wangjun.singleton;

public class SingletonStaticInnerTest {

	public static void main(String[] args) {
		
		Thread3[] ThreadArr = new Thread3[10];
		for (int i = 0; i < ThreadArr.length; i++) {
			ThreadArr[i] = new Thread3();
			ThreadArr[i].start();
		}
		
	}

}

class Thread3 extends Thread {
	@Override
	public void run() {
		System.out.println(SingletonStaticInner.getInstance().hashCode());
	}
}

//使用静态内部类实现单例模式
class SingletonStaticInner {
	private SingletonStaticInner() {
		
	}
	private static class SingletonInner {
		private static SingletonStaticInner singletonStaticInner = new SingletonStaticInner();
	}
	public static SingletonStaticInner getInstance() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return SingletonInner.singletonStaticInner;
	}
}
