package com.wangjun.singleton;

public class SingletonStaticBlockTest {

	public static void main(String[] args) {
		Thread4[] Thread1Arr = new Thread4[10];
		for (int i = 0; i < Thread1Arr.length; i++) {
			Thread1Arr[i] = new Thread4();
			Thread1Arr[i].start();
		}
	}

}

class Thread4 extends Thread {
	@Override
	public void run() {
		System.out.println(SingletonStaticBlock.getInstance().hashCode());
	}
}

//使用静态代码块实现单例模式
class SingletonStaticBlock {
	private static SingletonStaticBlock singletonStaticBlock;
	static {
		singletonStaticBlock = new SingletonStaticBlock();
	}
	public static SingletonStaticBlock getInstance() {
		return singletonStaticBlock;
	}
}
